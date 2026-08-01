class ParkingSystem {
    int car[];

    public ParkingSystem(int big, int medium, int small) {
        this.car = new int[] {big, medium, small};
    }
    
    public boolean addCar(int carType) {
        return car[carType-1]-- > 0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */