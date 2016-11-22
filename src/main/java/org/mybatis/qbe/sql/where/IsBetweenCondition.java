package org.mybatis.qbe.sql.where;

import org.mybatis.qbe.BaseTwoValueCondition;
import org.mybatis.qbe.Renderer;

public class IsBetweenCondition<T> extends BaseTwoValueCondition<T> {

    protected IsBetweenCondition(T value1, T value2) {
        super(value1, value2);
    }
    
    @Override
    public String render(Renderer parameterRenderer1, Renderer parameterRenderer2) {
        return String.format("between %s and %s", //$NON-NLS-1$
                parameterRenderer1.render(),
                parameterRenderer2.render());
    }

    public static class Builder<T> {
        private T value1;
        
        private Builder(T value1) {
            this.value1 = value1;
        }
        
        public IsBetweenCondition<T> and(T value2) {
            return new IsBetweenCondition<>(value1, value2);
        }
        
        public static <T> Builder<T> of(T value1) {
            return new Builder<>(value1);
        }
    }
}