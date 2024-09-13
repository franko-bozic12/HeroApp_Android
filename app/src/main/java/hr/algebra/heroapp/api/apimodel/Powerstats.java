
package hr.algebra.heroapp.api.apimodel;

import com.google.gson.annotations.SerializedName;

public class Powerstats {

    @SerializedName("combat")
    private Long mCombat;
    @SerializedName("durability")
    private Long mDurability;
    @SerializedName("intelligence")
    private Long mIntelligence;
    @SerializedName("power")
    private Long mPower;
    @SerializedName("speed")
    private Long mSpeed;
    @SerializedName("strength")
    private Long mStrength;

    public Long getCombat() {
        return mCombat;
    }

    public Long getDurability() {
        return mDurability;
    }

    public Long getIntelligence() {
        return mIntelligence;
    }

    public Long getPower() {
        return mPower;
    }

    public Long getSpeed() {
        return mSpeed;
    }

    public Long getStrength() {
        return mStrength;
    }

    public static class Builder {

        private Long mCombat;
        private Long mDurability;
        private Long mIntelligence;
        private Long mPower;
        private Long mSpeed;
        private Long mStrength;

        public Powerstats.Builder withCombat(Long combat) {
            mCombat = combat;
            return this;
        }

        public Powerstats.Builder withDurability(Long durability) {
            mDurability = durability;
            return this;
        }

        public Powerstats.Builder withIntelligence(Long intelligence) {
            mIntelligence = intelligence;
            return this;
        }

        public Powerstats.Builder withPower(Long power) {
            mPower = power;
            return this;
        }

        public Powerstats.Builder withSpeed(Long speed) {
            mSpeed = speed;
            return this;
        }

        public Powerstats.Builder withStrength(Long strength) {
            mStrength = strength;
            return this;
        }

        public Powerstats build() {
            Powerstats powerstats = new Powerstats();
            powerstats.mCombat = mCombat;
            powerstats.mDurability = mDurability;
            powerstats.mIntelligence = mIntelligence;
            powerstats.mPower = mPower;
            powerstats.mSpeed = mSpeed;
            powerstats.mStrength = mStrength;
            return powerstats;
        }

    }

}
