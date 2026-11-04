import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

void main() {

    // Opretter en Collator for dansk og svensk
    Collator dansk = Collator.getInstance(Locale.forLanguageTag("da-DK"));
    Collator svensk = Collator.getInstance(Locale.forLanguageTag("sv-SE"));

    // Opretter en liste med titler
    List<String> title = new ArrayList<>(List.of(
            "Økonomi",
            "Äpple",
            "Åbenbaringen"
    ));

    // Sorterer efter det danske alfabet
    title.sort(dansk);
    IO.println("Dansk sortering:");
    IO.println(title);

    // Sorterer efter det svenske alfabet
    title.sort(svensk);
    IO.println("Svensk sortering:");
    IO.println(title);
}