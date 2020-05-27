package com.challenge.interfaces;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public interface Calculavel {
    public BigDecimal somar(Object obj);
    public BigDecimal subtrair(Object obj);
    public BigDecimal totalizar(Object obj);
}
