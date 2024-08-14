public class CommandClasses {
}

 class BubbleSortCommand implements Command {
    private Orders[] orders;

    public BubbleSortCommand(Orders[] orders) {
        this.orders = orders;
    }

    @Override
    public void execute() {
        long startTime = System.nanoTime();
        Sortingalgorithms.bubbleSort(orders);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Orders sorted using Bubble Sort:");
        printOrders(orders);
        System.out.println("Time taken: " + duration + " nanoseconds");
    }

    private void printOrders(Orders[] orders) {
        for (Orders order : orders) {
            System.out.println(order);
        }
    }
}

 class QuickSortCommand implements Command {
    private Orders[] orders;

    public QuickSortCommand(Orders[] orders) {
        this.orders = orders;
    }

    @Override
    public void execute() {
        long startTime = System.nanoTime();
        Sortingalgorithms.quickSort(orders, 0, orders.length - 1);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Orders sorted using Quick Sort:");
        printOrders(orders);
        System.out.println("Time taken: " + duration + " nanoseconds");
    }

    private void printOrders(Orders[] orders) {
        for (Orders order : orders) {
            System.out.println(order);
        }
    }
}
