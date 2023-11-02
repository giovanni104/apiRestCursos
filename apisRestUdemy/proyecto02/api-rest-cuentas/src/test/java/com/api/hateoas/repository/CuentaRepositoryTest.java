package com.api.hateoas.repository;

import com.api.hateoas.model.Cuenta;
import com.api.hateoas.repository.CuentaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(value = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CuentaRepositoryTest {
    @Autowired
    private CuentaRepository cuentaRepository;

    @Test
    void testAgregarCuenta(){
        Cuenta cuenta = new Cuenta(8499339,"0029283");
        Cuenta cuentaGuardada = cuentaRepository.save(cuenta);

        Assertions.assertThat(cuentaGuardada).isNotNull(); //comprobamos que la cuenta no sea nula
        Assertions.assertThat(cuentaGuardada.getId()).isGreaterThan(0); // comprobamos que el ID de la cuenta guardada se mayor que 0
    }
}
