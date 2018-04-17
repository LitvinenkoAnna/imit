public class Data {
    private String id;
    private Group[] group;

    public Data(String id, Group... group) {
        this.id = id;
        group = new Group[group.length];
        for (int i = 0; i < group.length; i++) {
            this.group[i] = new Group(group[i]);

        }
    }

    public Data(Data copy) {
        this.id = copy.id;
        this.group = new Group[copy.group.length];
        for (int i = 0; i < group.length; i++) {
            this.group[i] = new Group(copy.group[i]);

        }
    }

    public String getId() {
        return id;

    }

    public void setId(String id) {
        this.id = id;

    }

    public Group[] getGroups() {

        return group;
    }

    public void setGroup(Group... group) {
        this.group = new Group[group.length];
        for (int i = 0; i < group.length; i++) {
            this.group[i] = new Group(group[i]);

        }
    }
    public int getSize(){
        return group.length;

    }
}
