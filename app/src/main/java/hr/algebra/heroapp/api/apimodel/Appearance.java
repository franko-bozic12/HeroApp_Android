package hr.algebra.heroapp.api.apimodel;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Appearance {

    @SerializedName("eyeColor")
    private String mEyeColor;
    @SerializedName("gender")
    private String mGender;
    @SerializedName("hairColor")
    private String mHairColor;
    @SerializedName("height")
    private List<String> mHeight;
    @SerializedName("race")
    private String mRace;
    @SerializedName("weight")
    private List<String> mWeight;

    public String getEyeColor() {
        return mEyeColor;
    }

    public String getGender() {
        return mGender;
    }

    public String getHairColor() {
        return mHairColor;
    }

    public List<String> getHeight() {
        return mHeight;
    }

    public String getRace() {
        return mRace;
    }

    public List<String> getWeight() {
        return mWeight;
    }

    public static class Builder {

        private String mEyeColor;
        private String mGender;
        private String mHairColor;
        private List<String> mHeight;
        private String mRace;
        private List<String> mWeight;

        public Appearance.Builder withEyeColor(String eyeColor) {
            mEyeColor = eyeColor;
            return this;
        }

        public Appearance.Builder withGender(String gender) {
            mGender = gender;
            return this;
        }

        public Appearance.Builder withHairColor(String hairColor) {
            mHairColor = hairColor;
            return this;
        }

        public Appearance.Builder withHeight(List<String> height) {
            mHeight = height;
            return this;
        }

        public Appearance.Builder withRace(String race) {
            mRace = race;
            return this;
        }

        public Appearance.Builder withWeight(List<String> weight) {
            mWeight = weight;
            return this;
        }

        public Appearance build() {
            Appearance appearance = new Appearance();
            appearance.mEyeColor = mEyeColor;
            appearance.mGender = mGender;
            appearance.mHairColor = mHairColor;
            appearance.mHeight = mHeight;
            appearance.mRace = mRace;
            appearance.mWeight = mWeight;
            return appearance;
        }

    }

}
