package TestClasses;

import java.util.Arrays;

public class Data {
    private String id;
    private Group[] group;

    public Data(String id, Group... group) {
        this.id = id;
        this.group = new Group[group.length];
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
    public  DataIterator iterator(){
        DataIterator dataIterator = new DataIterator(this);
        return dataIterator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        if (getId() != null ? !getId().equals(data.getId()) : data.getId() != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(group, data.group);
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + Arrays.hashCode(group);
        return result;
    }
}
