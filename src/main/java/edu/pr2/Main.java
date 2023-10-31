package edu.pr2;

public class Main {
    public static void main(String[] args) {
        MazeGenerator mazeGenerator = new MazeGenerator(200, 300);
        long startTime = System.currentTimeMillis();
        var m = mazeGenerator.generate();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Время выполнения: " + executionTime + " миллисекунд");

        Renderer r = new Renderer();
        r.render(m);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        MazeSolverBFS mazeSolver = new MazeSolverBFS();
        var ms = mazeSolver.solve(m, new Coordinate(1, 1), new Coordinate(9, 1));
        r.render(m, ms);

    }

}
