package Model;

/**
 * The Administrator class represents an administrator with a specific role and account ID.
 * Administrators are responsible for managing certain aspects of a system.
 *
 * @author User
 */
public class Administrator {
    private int roleId;
    private String accountId;

    /**
     * Default constructor for the Administrator class.
     */
    public Administrator() {
    }

    /**
     * Constructor to create an Administrator with specified role and account ID.
     *
     * @param roleId     The role ID of the administrator.
     * @param accountId  The account ID associated with the administrator.
     */
    public Administrator(int roleId, String accountId) {
        this.roleId = roleId;
        this.accountId = accountId;
    }

    /**
     * Get the role ID of the administrator.
     *
     * @return The role ID.
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Set the role ID of the administrator.
     *
     * @param roleId The role ID to set.
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Get the account ID associated with the administrator.
     *
     * @return The account ID.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Set the account ID associated with the administrator.
     *
     * @param accountId The account ID to set.
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
