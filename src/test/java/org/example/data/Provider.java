package org.example.data;

import org.testng.annotations.DataProvider;

public class Provider {
    @DataProvider(name = "credenciales")
    public static Object[][] datosDeCredenciales() {
        return new Object[][] {
                { "standard_user", "secret_sauce" },
                { "locked_out_user", "secret_sauce" },
                { "problem_user", "secret_sauce" },
        };
    }
}
