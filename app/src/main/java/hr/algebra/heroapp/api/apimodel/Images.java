
package hr.algebra.heroapp.api.apimodel;

import com.google.gson.annotations.SerializedName;

public class Images {

    @SerializedName("lg")
    private String mLg;
    @SerializedName("md")
    private String mMd;
    @SerializedName("sm")
    private String mSm;
    @SerializedName("xs")
    private String mXs;

    public String getLg() {
        return mLg;
    }

    public String getMd() {
        return mMd;
    }

    public String getSm() {
        return mSm;
    }

    public String getXs() {
        return mXs;
    }

    public static class Builder {

        private String mLg;
        private String mMd;
        private String mSm;
        private String mXs;

        public Images.Builder withLg(String lg) {
            mLg = lg;
            return this;
        }

        public Images.Builder withMd(String md) {
            mMd = md;
            return this;
        }

        public Images.Builder withSm(String sm) {
            mSm = sm;
            return this;
        }

        public Images.Builder withXs(String xs) {
            mXs = xs;
            return this;
        }

        public Images build() {
            Images images = new Images();
            images.mLg = mLg;
            images.mMd = mMd;
            images.mSm = mSm;
            images.mXs = mXs;
            return images;
        }

    }

}
