public class Member {
// Her gemmer vi medlemmets navn og ID
    final private String name;
    final private int memberId;

// Vi tilføjer navn og ID til konstruktøren
    public Member(String name, int memberId){
        this.name = name;
        this.memberId = memberId;
    }

// Getters
// Henter medlemmets navn (Ian sagde vi kom til at bruge det senere)
    public String getName() {
        return name;
    }

// Henter medlemmets ID
    public int getMemberId() {
        return memberId;
    }

// Retunerer medlemmets information som tekst
    @Override
    public String toString(){
        return String.format("%s (Loan number: %d) ", name, memberId);
    }
}