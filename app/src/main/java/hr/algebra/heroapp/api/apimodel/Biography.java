
package hr.algebra.heroapp.api.apimodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Biography {

    @SerializedName("aliases")
    private List<String> mAliases;
    @SerializedName("alignment")
    private String mAlignment;
    @SerializedName("alterEgos")
    private String mAlterEgos;
    @SerializedName("firstAppearance")
    private String mFirstAppearance;
    @SerializedName("fullName")
    private String mFullName;
    @SerializedName("placeOfBirth")
    private String mPlaceOfBirth;
    @SerializedName("publisher")
    private String mPublisher;

    public List<String> getAliases() {
        return mAliases;
    }

    public String getAlignment() {
        return mAlignment;
    }

    public String getAlterEgos() {
        return mAlterEgos;
    }

    public String getFirstAppearance() {
        return mFirstAppearance;
    }

    public String getFullName() {
        return mFullName;
    }

    public String getPlaceOfBirth() {
        return mPlaceOfBirth;
    }

    public String getPublisher() {
        return mPublisher;
    }

    public static class Builder {

        private List<String> mAliases;
        private String mAlignment;
        private String mAlterEgos;
        private String mFirstAppearance;
        private String mFullName;
        private String mPlaceOfBirth;
        private String mPublisher;

        public Biography.Builder withAliases(List<String> aliases) {
            mAliases = aliases;
            return this;
        }

        public Biography.Builder withAlignment(String alignment) {
            mAlignment = alignment;
            return this;
        }

        public Biography.Builder withAlterEgos(String alterEgos) {
            mAlterEgos = alterEgos;
            return this;
        }

        public Biography.Builder withFirstAppearance(String firstAppearance) {
            mFirstAppearance = firstAppearance;
            return this;
        }

        public Biography.Builder withFullName(String fullName) {
            mFullName = fullName;
            return this;
        }

        public Biography.Builder withPlaceOfBirth(String placeOfBirth) {
            mPlaceOfBirth = placeOfBirth;
            return this;
        }

        public Biography.Builder withPublisher(String publisher) {
            mPublisher = publisher;
            return this;
        }

        public Biography build() {
            Biography biography = new Biography();
            biography.mAliases = mAliases;
            biography.mAlignment = mAlignment;
            biography.mAlterEgos = mAlterEgos;
            biography.mFirstAppearance = mFirstAppearance;
            biography.mFullName = mFullName;
            biography.mPlaceOfBirth = mPlaceOfBirth;
            biography.mPublisher = mPublisher;
            return biography;
        }

    }

}
