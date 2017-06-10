package com.koou.annotation;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;
import com.sun.mirror.declaration.ClassDeclaration;
import com.sun.mirror.declaration.FieldDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;
import com.sun.mirror.util.SimpleDeclarationVisitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import static com.sun.mirror.util.DeclarationVisitors.NO_OP;
import static com.sun.mirror.util.DeclarationVisitors.getDeclarationScanner;

/**
 * Created by yunqiangdi on 3/17/2017.
 */
public class TableCreationProcessFactory implements AnnotationProcessorFactory {
    @Override
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> set, AnnotationProcessorEnvironment annotationProcessorEnvironment) {
        return new TableCreationProcess(annotationProcessorEnvironment);
    }

    @Override
    public Collection<String> supportedAnnotationTypes() {
        return Arrays.asList(
                "annotation.DBTable",
                "annotation.Constraints",
                "annotation.SQLString",
                "annotation.SQLInteger");
    }

    @Override
    public Collection<String> supportedOptions() {
        return Collections.emptySet();
    }

    private static class TableCreationProcess implements AnnotationProcessor {
        private final AnnotationProcessorEnvironment env;
        private String sql = "";

        public TableCreationProcess(AnnotationProcessorEnvironment env) {
            this.env = env;
        }

        @Override
        public void process() {
            for (TypeDeclaration typeDecl : env.getSpecifiedTypeDeclarations()) {
                typeDecl.accept(getDeclarationScanner(new TableCreationVisitor(), NO_OP));
                sql = sql.substring(0, sql.length() - 1) + ");";
                System.out.println("creation SQL is : \n" + sql);
                sql = "";
            }
        }

        private class TableCreationVisitor extends SimpleDeclarationVisitor {
            @Override
            public void visitClassDeclaration(ClassDeclaration d) {
                DBTable dbTable = d.getAnnotation(DBTable.class);
                if (dbTable != null) {
                    sql += "CREATE TABLE";
                    sql += (dbTable.name().length() < 1) ?
                            d.getSimpleName().toUpperCase()
                            : dbTable.name();
                    sql += "(";
                }
            }

            @Override
            public void visitFieldDeclaration(FieldDeclaration d) {
                String columnName = "";
                if (d.getAnnotation(SQLInteger.class) != null) {
                    SQLInteger sInt = d.getAnnotation(SQLInteger.class);
                    columnName = (sInt.name().length() < 1)
                            ? d.getSimpleName().toUpperCase()
                            : sInt.name();
                    sql += "\n   " + columnName + " INT" + getConstraints(sInt.constraints())
                            + ",";
                }

                if (d.getAnnotation(SQLString.class) != null) {
                    SQLString sString = d.getAnnotation(SQLString.class);
                    columnName = (sString.name().length() < 1)
                            ? d.getSimpleName().toUpperCase()
                            : sString.name();
                    sql += "\n   " + columnName + " VARCHAR(" + sString.value() + ")"
                            + getConstraints(sString.constraints())
                            + ",";
                }
            }

            private String getConstraints(Constraints con) {
                String constraints = "";
                if (!con.allowNull())
                    constraints += " NOT NULL";
                if (con.primaryKey())
                    constraints += " PRIMARY KEY";
                if (con.unique())
                    constraints += " UNIQUE";
                return constraints;
            }


        }
    }
}
