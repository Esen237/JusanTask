package API.POJOAPI;

public enum URI {
    LISTUSERS("/users"),
    REGISTER("/register"),
    UPDATE("/users/"),
    DELETE("/users/"),
    SINGLEUSER("/users/"),
    CREATE("/users");


    public final String endpoints;
    private URI(String endpoints) {
        this.endpoints = endpoints;
    }
}
