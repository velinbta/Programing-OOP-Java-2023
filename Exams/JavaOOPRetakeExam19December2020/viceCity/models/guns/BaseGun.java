package viceCity.models.guns;

import viceCity.common.ExceptionMessage;

import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public abstract class BaseGun implements Gun {

    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private int bulletsPerShot;
    private int capacity;
    private boolean canFire;

    protected BaseGun(String name, int bulletsPerBarrel, int totalBullets, int bulletsPerShot) {
        this.setName(name);
        this.setBulletsPerBarrel(bulletsPerBarrel);
        this.capacity = this.getBulletsPerBarrel();
        this.setTotalBullets(totalBullets);
        this.bulletsPerShot = bulletsPerShot;
        this.canFire = this.canFire();
    }

    @Override
    public int fire() {

        if (!this.canFire()) {
            return 0;
        }

        this.setBulletsPerBarrel(this.getBulletsPerBarrel() - this.bulletsPerShot);

        if (this.gunNeedsReloading() && this.canGunReload()) {
            this.setTotalBullets(this.getTotalBullets() - this.capacity);
            this.setBulletsPerBarrel(this.capacity);
        }

        return this.bulletsPerShot;
    }

    @Override
    public boolean canFire() {

        boolean canFireWithCurrentBulletsPerBarrel = this.bulletsPerShot <= this.getBulletsPerBarrel();
        boolean canFireAfterReloading = this.canGunReload();

        this.canFire = canFireWithCurrentBulletsPerBarrel || canFireAfterReloading;

        return this.canFire;
    }

    private boolean canGunReload() {
        return this.getTotalBullets() - this.capacity >= 0;
    }

    private boolean gunNeedsReloading() {
        return this.getBulletsPerBarrel() <= 0;
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new NullPointerException(ExceptionMessage.NAME_NULL);
        }
        this.name = name;
    }

    private void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (this.isBelowZero(bulletsPerBarrel)) {
            throw new IllegalArgumentException(ExceptionMessage.BULLETS_LESS_THAN_ZERO);
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    private void setTotalBullets(int totalBullets) {
        if (this.isBelowZero(totalBullets)) {
            throw new IllegalArgumentException(ExceptionMessage.TOTAL_BULLETS_LESS_THAN_ZERO);
        }
        this.totalBullets = totalBullets;
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private boolean isBelowZero(int value) {
        return value < 0;
    }

}
