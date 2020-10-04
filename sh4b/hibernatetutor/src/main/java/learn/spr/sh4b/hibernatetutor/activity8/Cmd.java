package learn.spr.sh4b.hibernatetutor.activity8;

public enum Cmd {
    SAVE(1, "Save Employee"),
    GET_BY_ID(2, "Get Employee by ID"),
    GET_BY_COMPANY(3, "Get Employees by Company"),
    DELETE(4, "Delete Employee by ID"),
    LIST(5,"List All Employees"),
    EXIT(6, "Exit")
    ;
    private final int id;
    private final String title;

    Cmd(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public static Cmd findById(int id) {
        for (Cmd c : Cmd.values()) {
            if (c.id == id) {
                return c;
            }
        }
        throw new IllegalArgumentException("Can not find Cmd with id=" + id);
    }

    @Override
    public String toString() {
        return id + " - " + title;
    }
}
