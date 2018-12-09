package br.com.experian.gerenciadorperfil.core.util;

public final class EnvironmentUtils {

	public static boolean isAmbienteLocal() {
        return ("LO".equalsIgnoreCase(getEnvironment()));
    }

    public static boolean isAmbienteDesenvOrLocalOrHomologacao() {
        return isAmbienteDesenvOrLocal() || isAmbienteHomologacao();
    }

    public static boolean isAmbienteProducaoOrHomologacao(){
        return isAmbienteProducao() || isAmbienteHomologacao();
    }

    public static boolean isAmbienteProducao() {
        return ("PE".equalsIgnoreCase(getEnvironment()) || "PI".equalsIgnoreCase(getEnvironment()));
    }

    public static boolean isAmbienteHomologacao() {
        return ("HI".equalsIgnoreCase(getEnvironment()));
    }

    public static boolean isAmbienteDesenvOrLocal() {
        return ("LO".equalsIgnoreCase(getEnvironment()) || "DE".equalsIgnoreCase(getEnvironment()));
    }

    private static String getEnvironment(){
        return System.getProperty("environment.name");
    }

	private EnvironmentUtils() {

	}
}
