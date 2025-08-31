package io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.filters.FilterChain;
import com.openpojo.reflection.filters.FilterEnum;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.rule.impl.EqualsAndHashCodeMatchRule;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import java.util.List;
import org.junit.jupiter.api.Test;

class PojoModelTest {

    private static final int EXPECTED_CLASS_COUNT = 2;
    private static final String POJO_PACKAGE = "io.github.aliaksandrrachko.spacex.dragon.rockets.repository.core.api.model";
    private static final PojoClassFilter FILTER = new FilterChain(new FilterPackageInfo(), new FilterEnum(), new FilterTestClasses());

    @Test
    void ensureExpectedPojoCount() {
        List<PojoClass> pojoClasses = PojoClassFactory.getPojoClassesRecursively(POJO_PACKAGE, FILTER);
        Affirm.affirmEquals("Classes added / removed?", EXPECTED_CLASS_COUNT, pojoClasses.size());
    }

    @Test
    void testAllModels() {
        Validator validator = ValidatorBuilder.create()
              .with(new GetterMustExistRule())
              .with(new SetterMustExistRule())
              .with(new EqualsAndHashCodeMatchRule())
              .with(new GetterTester())
              .with(new SetterTester())
              .build();

        validator.validateRecursively(POJO_PACKAGE, FILTER);
    }
}
