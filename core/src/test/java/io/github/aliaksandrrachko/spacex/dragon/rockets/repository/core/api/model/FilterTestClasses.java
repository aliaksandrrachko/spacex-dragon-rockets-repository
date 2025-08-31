package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;

public class FilterTestClasses implements PojoClassFilter {
  @Override
  public boolean include(PojoClass pojoClass) {
    return !pojoClass.getName().contains("Test");
  }
}
