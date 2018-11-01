package fr.ynov.dap.client.model;

/**
 * Represent login status.
 * @author Kévin Sibué
 *
 */
public enum LoginStatusEnum {

    /**
     * User account already added.
     */
    ALREADY_ADDED(1),

    /**
     * Error occurred when user try to login.
     */
    ERROR(2),

    /**
     * User auth success, you must be redirected.
     */
    REDIRECTION(3);

    /**
     * Current value.
     */
    private final Integer value;

    /**
     * Default constructor.
     * @param val status value.
     */
    LoginStatusEnum(final Integer val) {
        this.value = val;
    }

    /**
     * Get current value.
     * @return Current value.
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Transform integer to enum.
     * @param status Current status to be converted
     * @return New enum status
     */
    public static LoginStatusEnum getStatusFromInt(final int status) {
        for (LoginStatusEnum stat : LoginStatusEnum.values()) {
            if (stat.value == status) {
                return stat;
            }
        }
        return LoginStatusEnum.ERROR;
    }

}
