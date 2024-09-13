
package hr.algebra.heroapp.api.apimodel;

import com.google.gson.annotations.SerializedName;

public class HeroItem {

    @SerializedName("appearance")
    private Appearance mAppearance;
    @SerializedName("biography")
    private Biography mBiography;
    @SerializedName("connections")
    private Connections mConnections;
    @SerializedName("id")
    private Long mId;
    @SerializedName("images")
    private Images mImages;
    @SerializedName("name")
    private String mName;
    @SerializedName("powerstats")
    private Powerstats mPowerstats;
    @SerializedName("slug")
    private String mSlug;
    @SerializedName("work")
    private Work mWork;

    public Appearance getAppearance() {
        return mAppearance;
    }

    public Biography getBiography() {
        return mBiography;
    }

    public Connections getConnections() {
        return mConnections;
    }

    public Long getId() {
        return mId;
    }

    public Images getImages() {
        return mImages;
    }

    public String getName() {
        return mName;
    }

    public Powerstats getPowerstats() {
        return mPowerstats;
    }

    public String getSlug() {
        return mSlug;
    }

    public Work getWork() {
        return mWork;
    }

    public static class Builder {

        private Appearance mAppearance;
        private Biography mBiography;
        private Connections mConnections;
        private Long mId;
        private Images mImages;
        private String mName;
        private Powerstats mPowerstats;
        private String mSlug;
        private Work mWork;

        public HeroItem.Builder withAppearance(Appearance appearance) {
            mAppearance = appearance;
            return this;
        }

        public HeroItem.Builder withBiography(Biography biography) {
            mBiography = biography;
            return this;
        }

        public HeroItem.Builder withConnections(Connections connections) {
            mConnections = connections;
            return this;
        }

        public HeroItem.Builder withId(Long id) {
            mId = id;
            return this;
        }

        public HeroItem.Builder withImages(Images images) {
            mImages = images;
            return this;
        }

        public HeroItem.Builder withName(String name) {
            mName = name;
            return this;
        }

        public HeroItem.Builder withPowerstats(Powerstats powerstats) {
            mPowerstats = powerstats;
            return this;
        }

        public HeroItem.Builder withSlug(String slug) {
            mSlug = slug;
            return this;
        }

        public HeroItem.Builder withWork(Work work) {
            mWork = work;
            return this;
        }

        public HeroItem build() {
            HeroItem heroItem = new HeroItem();
            heroItem.mAppearance = mAppearance;
            heroItem.mBiography = mBiography;
            heroItem.mConnections = mConnections;
            heroItem.mId = mId;
            heroItem.mImages = mImages;
            heroItem.mName = mName;
            heroItem.mPowerstats = mPowerstats;
            heroItem.mSlug = mSlug;
            heroItem.mWork = mWork;
            return heroItem;
        }

    }

}
