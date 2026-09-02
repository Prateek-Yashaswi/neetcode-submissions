class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        return solve(target, position, speed);
    }

    private record Car(
            int position,
            int speed
    ) {

    }

    private static int solve(int target, int[] position, int[] speed) {
        var cars = IntStream.range(0, position.length)
                .boxed()
                .map(idx -> new Car(position[idx], speed[idx]))
                .sorted((obj1, obj2) -> Integer.compare(obj2.position, obj1.position))
                .toList();

        Double lastFleetTime = null;
        var fleetCount = 0;
        for (var car: cars) {
            var time = (double) (target - car.position) / car.speed;
            
            if (Objects.isNull(lastFleetTime) || time > lastFleetTime) {
                lastFleetTime = time;
                fleetCount++;
            }
        }

        return fleetCount;
    }
}
