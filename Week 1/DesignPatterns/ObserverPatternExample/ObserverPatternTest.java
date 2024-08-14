public class ObserverPatternTest {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        Observer channel1 = new NewsChannel("Channel 1");
        Observer channel2 = new NewsChannel("Channel 2");

        newsAgency.addObserver(channel1);
        newsAgency.addObserver(channel2);

        newsAgency.setNews("Breaking News: Observer Pattern in Java!");

        newsAgency.removeObserver(channel1);

        newsAgency.setNews("More News: Observer Pattern Update!");
    }
}
