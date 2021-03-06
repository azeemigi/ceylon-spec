package com.redhat.ceylon.compiler.typechecker.tree;

import org.antlr.runtime.Token;

public class CustomTree extends Tree {
    
    public static class FunctionArgument 
            extends Tree.FunctionArgument {
        public FunctionArgument(Token token) {
            super(token);
        }
        @Override
        public void visitChildren(Visitor visitor) {
            if (getType()!=null)
                getType().visit(visitor);
            for (ParameterList pl: getParameterLists())
                pl.visit(visitor);
            if (getExpression()!=null)
                getExpression().visit(visitor);
        }
        @Override public String getNodeType() {
            return FunctionArgument.class.getSimpleName();
        }
    }

    public static class AttributeDeclaration 
            extends Tree.AttributeDeclaration {
        public AttributeDeclaration(Token token) {
            super(token);
        }
        @Override
        public void visit(Visitor visitor) {
            if (visitor instanceof NaturalVisitor) {
                super.visit(visitor);
            }
            else {
                if (getSpecifierOrInitializerExpression()!=null)
                    getSpecifierOrInitializerExpression().visit(visitor);
                super.visit(visitor);
            }
        }
        @Override
        public void visitChildren(Visitor visitor) {
            if (visitor instanceof NaturalVisitor) {
                super.visitChildren(visitor);
            }
            else {
                Walker.walkAnyAttribute(visitor, this);
            }
        }
        @Override public String getNodeType() {
            return AttributeDeclaration.class.getSimpleName();
        }
    }
    
    public static class MethodDeclaration 
            extends Tree.MethodDeclaration {
        public MethodDeclaration(Token token) {
            super(token);
        }
        @Override
        public void visit(Visitor visitor) {
            if (visitor instanceof NaturalVisitor) {
                super.visit(visitor);
            }
            else {
                if (getSpecifierExpression()!=null)
                    getSpecifierExpression().visit(visitor);
                super.visit(visitor);
            }
        }
        @Override
        public void visitChildren(Visitor visitor) {
            if (visitor instanceof NaturalVisitor) {
                super.visitChildren(visitor);
            }
            else {
                if (getTypeParameterList()!=null)
                    getTypeParameterList().visit(visitor);
                if (getTypeConstraintList()!=null)
                    getTypeConstraintList().visit(visitor);
                Walker.walkTypedDeclaration(visitor, this);
                for (Tree.ParameterList subnode: getParameterLists())
                    subnode.visit(visitor);
            }
        }
        @Override public String getNodeType() {
            return MethodDeclaration.class.getSimpleName();
        }
    }
    
    public static class MethodDefinition 
            extends Tree.MethodDefinition {
        public MethodDefinition(Token token) {
            super(token);
        }
        @Override
        public void visitChildren(Visitor visitor) {
            if (visitor instanceof NaturalVisitor) {
                super.visitChildren(visitor);
            }
            else {
                Walker.walkDeclaration(visitor, this);
                if (getTypeParameterList()!=null)
                    getTypeParameterList().visit(visitor);
                if (getTypeConstraintList()!=null)
                    getTypeConstraintList().visit(visitor);
                if (getType()!=null)
                    getType().visit(visitor);
                for (Tree.ParameterList subnode: getParameterLists())
                    subnode.visit(visitor);
                if (getBlock()!=null)
                    getBlock().visit(visitor);
            }
        }
        @Override public String getNodeType() {
            return MethodDefinition.class.getSimpleName();
        }
    }
    
    public static class ClassDefinition 
            extends Tree.ClassDefinition {
        public ClassDefinition(Token token) {
            super(token);
        }
        @Override
        public void visitChildren(Visitor visitor) {
            if (visitor instanceof NaturalVisitor) {
                Walker.walkDeclaration(visitor, this);
                if (getTypeParameterList()!=null)
                    getTypeParameterList().visit(visitor);
                if (getParameterList()!=null)
                    getParameterList().visit(visitor);
                if (getCaseTypes()!=null)
                    getCaseTypes().visit(visitor);
                if (getExtendedType()!=null)
                    getExtendedType().visit(visitor);
                if (getSatisfiedTypes()!=null)
                    getSatisfiedTypes().visit(visitor);
                if (getTypeConstraintList()!=null)
                    getTypeConstraintList().visit(visitor);
                if (getClassBody()!=null)
                    getClassBody().visit(visitor);
            }
            else {
                Walker.walkDeclaration(visitor, this);
                if (getTypeParameterList()!=null)
                    getTypeParameterList().visit(visitor);
                if (getTypeConstraintList()!=null)
                    getTypeConstraintList().visit(visitor);
                if (getParameterList()!=null)
                    getParameterList().visit(visitor);
                if (getCaseTypes()!=null)
                    getCaseTypes().visit(visitor);
                if (getExtendedType()!=null)
                    getExtendedType().visit(visitor);
                if (getSatisfiedTypes()!=null)
                    getSatisfiedTypes().visit(visitor);
                if (getClassBody()!=null)
                    getClassBody().visit(visitor);
            }
        }
        @Override public String getNodeType() {
            return ClassDefinition.class.getSimpleName();
        }
    }
    
    public static class ValueParameterDeclaration 
            extends Tree.ValueParameterDeclaration {
        public ValueParameterDeclaration(Token token) {
            super(token);
        }
        @Override
        public void visit(Visitor visitor) {
            if (visitor instanceof NaturalVisitor) {
                super.visit(visitor);
            }
            else {
                if (getDefaultArgument()!=null)
                    getDefaultArgument().visit(visitor);
                super.visit(visitor);
            }
        }
        @Override
        public void visitChildren(Visitor visitor) {
            if (visitor instanceof NaturalVisitor) {
                super.visitChildren(visitor);
            }
            else {
                Walker.walkTypedDeclaration(visitor, this);
            }
        }
        @Override public String getNodeType() {
            return ValueParameterDeclaration.class.getSimpleName();
        }
    }
    
    public static class FunctionalParameterDeclaration 
            extends Tree.FunctionalParameterDeclaration {
        public FunctionalParameterDeclaration(Token token) {
            super(token);
        }
        @Override
        public void visit(Visitor visitor) {
            if (visitor instanceof NaturalVisitor) {
                super.visit(visitor);
            }
            else {
                if (getDefaultArgument()!=null)
                    getDefaultArgument().visit(visitor);
                super.visit(visitor);
            }
        }
        @Override
        public void visitChildren(Visitor visitor) {
            if (visitor instanceof NaturalVisitor) {
                super.visitChildren(visitor);
            }
            else {
                Walker.walkTypedDeclaration(visitor, this);
                for (Tree.ParameterList subnode: getParameterLists())
                    subnode.visit(visitor);
            }
        }
        @Override public String getNodeType() {
            return FunctionalParameterDeclaration.class.getSimpleName();
        }
    }
    
    public static class ExtendedTypeExpression 
            extends Tree.ExtendedTypeExpression {
        public ExtendedTypeExpression(Token token) {
            super(token);
        }
        @Override public String getNodeType() {
            return ExtendedTypeExpression.class.getSimpleName();
        }
        public void setExtendedType(SimpleType type) {
            connect(type);
        }
    }
    
    public static class StringLiteral
            extends Tree.StringLiteral {
        public StringLiteral(Token token) {
            super(token);
        }
        @Override
        public String getText() {
            int start = getToken().getCharPositionInLine()+1;
            StringBuilder result = new StringBuilder();
            int num = 0;
            for (String line: super.getText().split("\n|\r\n?")) {
                if (num++==0 || line.length()<start) {
                    result.append(line);
                }
                else {
                    boolean trimIndent = true;
                    for (int i=0; i<start; i++) {
                        if (line.charAt(i)!=' ') {
                            trimIndent = false;
                            break;
                        }
                    }
                    if (trimIndent) {
                        result.append(line.substring(start));
                    }
                    else {
                        result.append(line);
                    }
                }
                result.append("\n");
            }
            result.setLength(result.length()-1);
            return result.toString();
        }
        
    }
    
    public static class NaturalLiteral
            extends Tree.NaturalLiteral {
        public NaturalLiteral(Token token) {
            super(token);
        }
        @Override
        public String getText() {
            return super.getText().replace("_", "")
                    .replace("k", "000")
                    .replace("M", "000000")
                    .replace("G", "000000000")
                    .replace("T", "000000000000")
                    .replace("P", "000000000000000");
        }
    }

    public static class FloatLiteral
            extends Tree.FloatLiteral {
        public FloatLiteral(Token token) {
            super(token);
        }
        @Override
        public String getText() {
            return super.getText().replace("_", "")
                    .replace("k", "e+3")
                    .replace("M", "e+6")
                    .replace("G", "e+9")
                    .replace("T", "e+12")
                    .replace("P", "e+15")
                    .replace("m", "e-3")
                    .replace("u", "e-6")
                    .replace("n", "e-9")
                    .replace("p", "e-12")
                    .replace("f", "e-15");
        }
    }
    
    public static class IsCase
            extends Tree.IsCase {
        private Variable variable;
        public IsCase(Token token) {
            super(token);
        }
        @Override
        public void setVariable(Variable node) {
            variable = node;
        }
        @Override
        public Variable getVariable() {
            return variable;
        }
    }

}
