public class HeroTest {
    public static int marioWin = 0;
    public static int dkWin = 0;
    public static void main(String[] args) {
        
        
        for (int i = 0; i < 50; i++) {
            
            battle();
        }
        System.out.printf("%s wins: %d %n%s wins: %d", "Mario", marioWin, "Donkey Kong", dkWin);
    }

    public static Hero battle() {

        Hero winner = null;
        boolean running = true;
        Hero mario = new Hero("Mario", 2,3,2,3,1,5 );
        Hero donkeyKong = new Hero("Donkey Kong", 5,1,4,3,3,5);

        System.out.println(Hero.heroCount);
        while (running) {
            donkeyKong.attack(mario);
            mario.attack(donkeyKong);

            if (donkeyKong.getAlive() == false) {
                winner = mario;
                marioWin++;
                running = false;
            } else if (mario.getAlive() == false) {
                winner = donkeyKong;
                dkWin++;
                running = false;
            } else {
                winner = null;
            }
        }
        System.out.println("The winner is " + winner.getName());
        return winner;

    }
}
