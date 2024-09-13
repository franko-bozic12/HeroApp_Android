
package hr.algebra.heroapp.api.apimodel;

import com.google.gson.annotations.SerializedName;

public class Work {

    @SerializedName("base")
    private String mBase;
    @SerializedName("occupation")
    private String mOccupation;

    public String getBase() {
        return mBase;
    }

    public String getOccupation() {
        return mOccupation;
    }

    public static class Builder {

        private String mBase;
        private String mOccupation;

        public Work.Builder withBase(String base) {
            mBase = base;
            return this;
        }

        public Work.Builder withOccupation(String occupation) {
            mOccupation = occupation;
            return this;
        }

        public Work build() {
            Work work = new Work();
            work.mBase = mBase;
            work.mOccupation = mOccupation;
            return work;
        }

    }

}
