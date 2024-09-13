
package hr.algebra.heroapp.api.apimodel;

import com.google.gson.annotations.SerializedName;

public class Connections {

    @SerializedName("groupAffiliation")
    private String mGroupAffiliation;
    @SerializedName("relatives")
    private String mRelatives;

    public String getGroupAffiliation() {
        return mGroupAffiliation;
    }

    public String getRelatives() {
        return mRelatives;
    }

    public static class Builder {

        private String mGroupAffiliation;
        private String mRelatives;

        public Connections.Builder withGroupAffiliation(String groupAffiliation) {
            mGroupAffiliation = groupAffiliation;
            return this;
        }

        public Connections.Builder withRelatives(String relatives) {
            mRelatives = relatives;
            return this;
        }

        public Connections build() {
            Connections connections = new Connections();
            connections.mGroupAffiliation = mGroupAffiliation;
            connections.mRelatives = mRelatives;
            return connections;
        }

    }

}
