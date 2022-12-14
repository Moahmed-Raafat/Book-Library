package com.example.booklibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.SystemClock;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;

    Intent intent;
    private ArrayList<Book> books2;
    DatabaseHelper databaseHelper;


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        books2=new ArrayList<>();
        books2.add(new Book("introduction to java","Y. Daniel","https://images-na.ssl-images-amazon.com/images/I/51hOnFPzUfL._SX398_BO1,204,203,200_.jpg","Intro to Java Programming, Comprehensive Version (10th Edition) 10th Edition"));
        books2.add(new Book("Ulysses","James Joyce","https://almabooks.com/wp-content/uploads/2016/10/ulysses-evergreen-james-joyce-1.jpg","Ulysses is a modernist novel by Irish writer James Joyce. It was first serialized in parts in the American journal The Little Review from March 1918 to December 1920 and then published in its entirety in Paris by Sylvia Beach on 2 February 1922, Joyce's 40th birthday. It is considered one of the most important works of modernist literature[1] and has been called .a demonstration and summation of the entire movement. According to Declan Kiberd, Before Joyce, no writer of fiction had so foregrounded the process of thinking"));
        books2.add(new Book("Don Quixote","Miguel de Cervantes","https://m.media-amazon.com/images/I/51iQq6ZYedL.jpg","Don Quixote, Spanish in full, Part 1 El ingenioso hidalgo don Quijote de la Mancha (“The Ingenious Hidalgo Don Quixote of La Mancha”) and Part 2 Segunda parte del ingenioso caballero don Quijote de la Mancha (“Second Part of the Ingenious Knight Don Quixote of La Mancha”)"));
        books2.add(new Book("One Hundred Years of Solitude","Gabriel Garcia Marquez","https://images-na.ssl-images-amazon.com/images/I/91mftQtgAkL.jpg","The brilliant, bestselling, landmark novel that tells the story of the Buendia family, and chronicles the irreconcilable conflict between the desire for solitude and the need for love—in rich, imaginative prose that has come to define an entire genre known as (magical realism)"));
        books2.add(new Book("The Great Gatsby","F. Scott Fitzgerald","https://d28hgpri8am2if.cloudfront.net/book_images/onix/cvr9781982146702/the-great-gatsby-9781982146702_hr.jpg","The Great Gatsby is a 1925 novel by American writer F. Scott Fitzgerald. Set in the Jazz Age on Long Island, near New York City, the novel depicts first-person narrator Nick Carraway's interactions with mysterious millionaire Jay Gatsby and Gatsby's obsession to reunite with his former lover, Daisy Buchanan"));
        books2.add(new Book("Moby Dick","Herman Melville","https://kbimages1-a.akamaihd.net/34c5bfd3-a8d0-4500-a321-a1533c3af3f7/1200/1200/False/moby-dick-118.jpg","Moby Dick famously begins with the narratorial invocation “Call me Ishmael.” The narrator, like his biblical counterpart, is an outcast. Ishmael, who turns to the sea for meaning, relays to the audience the final voyage of the Pequod, a whaling vessel. Amid a story of tribulation, beauty, and madness, the reader is introduced to a number of characters, many of whom have names with religious resonance. The ship’s captain is Ahab, who Ishmael and his friend Queequeg soon learn is losing his mind. Starbuck, Ahab’s first-mate, recognizes this problem too, and is the only one throughout the novel to voice his disapproval of Ahab’s increasingly obsessive behavior. This nature of Ahab’s obsession is first revealed to Ishmael and Queequeg after the Pequod’s owners, Peleg and Bildad, explain to them that Ahab is still recovering from an encounter with a large whale that resulted in the loss of his leg. That whale’s name is Moby Dick. The Pequod sets sail, and the crew is soon informed that this journey will be unlike their other whaling missions: this time, despite the reluctance of Starbuck, Ahab intends to hunt and kill the beastly Moby Dick no matter the cost.Ahab and the crew continue their eventful journey and encounter a number of obstacles along the way. Queequeg falls ill, which prompts a coffin to be built in anticipation of the worst. After he recovers, the coffin becomes a replacement lifeboat that eventually saves Ishmael’s life. Ahab receives a prophecy from a crew member informing him of his future death, which he ignores. Moby Dick is spotted and, over the course of three days, engages violently with Ahab and the Pequod until the whale destroys the ship, killing everyone except Ishmael. Ishmael survives by floating on Queequeg’s coffin until he is picked up by another ship, the Rachel. The novel consists of 135 chapters, in which narrative and essayistic portions intermingle, as well as an epilogue and front matter."));
        books2.add(new Book("War and Peace","Leo Tolstoy","https://images-na.ssl-images-amazon.com/images/I/A1aDb5U5myL.jpg","In Russia's struggle with Napoleon, Tolstoy saw a tragedy that involved all mankind. Greater than a historical chronicle, War and Peace is an affirmation of life itself, `a complete picture', as a contemporary reviewer put it, `of everything in which people find their happiness and greatness, their grief and humiliation'. Tolstoy gave his personal approval to this translation, published here in a new single volume edition, which includes an introduction by Henry Gifford, and Tolstoy's important essay `Some Words about War and Peace'."));
        books2.add(new Book("Hamlet","William Shakespeare","https://kbimages1-a.akamaihd.net/5fc4252b-1c4f-40ef-9975-22982c94f12c/1200/1200/False/hamlet-prince-of-denmark-23.jpg","Among Shakespeare's plays, \"Hamlet\" is considered by many his masterpiece. Among actors, the role of Hamlet, Prince of Denmark, is considered the jewel in the crown of a triumphant theatrical career. Now Kenneth Branagh plays the leading role and co-directs a brillant ensemble performance. Three generations of legendary leading actors, many of whom first assembled for the Oscar-winning film \"Henry V\", gather here to perform the rarely heard complete version of the play. This clear, subtly nuanced, stunning dramatization, presented by The Renaissance Theatre Company in association with \"Bbc\" Broadcasting, features such luminaries as Sir John Gielgud, Derek Jacobi, Emma Thompson and Christopher Ravenscroft. It combines a full cast with stirring music and sound effects to bring this magnificent Shakespearen classic vividly to life. Revealing new riches with each listening, this production of \"Hamlet\" is an invaluable aid for students, teachers and all true lovers of Shakespeare - a recording to be treasured for decades to come."));
        books2.add(new Book("The Odyssey","Homer","https://images-na.ssl-images-amazon.com/images/I/81QAAnCNM7L.jpg","Sing to me of the man, Muse, the man of twists and turns\n" +
                "driven time and again off course, once he had plundered\n" +
                "the hallowed heights of Troy.\n" +
                "\n" +
                "So begins Robert Fagles' magnificent translation of the Odyssey.\n" +
                "\n" +
                "If the Iliad is the world's greatest war epic, then the Odyssey is literature's grandest evocation of everyman's journey though life. Odysseus' reliance on his wit and wiliness for survival in his encounters with divine and natural forces, during his ten-year voyage home to Ithaca after the Trojan War, is at once a timeless human story and an individual test of moral endurance.\n" +
                "\n" +
                "In the myths and legends that are retold here, Fagles has captured the energy and poetry of Homer's original in a bold, contemporary idiom, and given us an Odyssey to read aloud, to savor, and to treasure for its sheer lyrical mastery.\n" +
                "\n" +
                "Renowned classicist Bernard Knox's superb Introduction and textual commentary provide new insights and background information for the general reader and scholar alike, intensifying the strength of Fagles' translation.\n" +
                "\n" +
                "This is an Odyssey to delight both the classicist and the public at large, and to captivate a new generation of Homer's students.\n" +
                "\n" +
                "--\n" +
                "\n" +
                "Robert Fagles, winner of the PEN/Ralph Manheim Medal for Translation and a 1996 Academy Award in Literature from the American Academy of Arts and Letters, presents us with Homer's best-loved and most accessible poem in a stunning new modern-verse translation."));
        books2.add(new Book("Madame Bovary ","Gustave Flaubert","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1606770119i/2175._UY500_SS500_.jpg","Madame Bovary is the debut novel of French writer Gustave Flaubert, published in 1856. The character lives beyond her means in order to escape the banalities and emptiness of provincial life. When the novel was first serialized in La Revue de Paris between 1 October 1856 and 15 December 1856, public prosecutors attacked the novel for obscenity. The resulting trial in January 1857 made the story notorious. After Flaubert's acquittal on 7 February 1857, Madame Bovary became a bestseller in April 1857 when it was published in two volumes. A seminal work of literary realism, the novel is now considered Flaubert's masterpiece, and one of the most influential literary works in history."));
        books2.add(new Book("The Divine Comedy ","Dante Alighieri","https://images-na.ssl-images-amazon.com/images/I/A1I2Kx625BL.jpg","The Divine Comedy describes Dante's descent into Hell with Virgil as a guide; his ascent of Mount Purgatory and encounter with his dead love, Beatrice; and finally, his arrival in Heaven. Examining questions of faith, desire and enlightenment, the poem is a brilliantly nuanced and moving allegory of human redemption.\n" +
                "\n" +
                "Dante Alighieri was born in Florence in 1265 and belonged to a noble but impoverished family. His life was divided by political duties and poetry, the most of famous of which was inspired by his meeting with Bice Portinari, whom he called Beatrice,including La Vita Nuova and The Divine Comedy. He died in Ravenna in 1321."));
        books2.add(new Book("Lolita ","Vladimir Nabokov","https://upload.wikimedia.org/wikipedia/commons/5/57/Lolita_1955.JPG","Humbert Humbert - scholar, aesthete and romantic - has fallen completely and utterly in love with Dolores Haze, his landlady's gum-snapping, silky skinned twelve-year-old daughter. Reluctantly agreeing to marry Mrs Haze just to be close to Lolita, Humbert suffers greatly in the pursuit of romance; but when Lo herself starts looking for attention elsewhere, he will carry her off on a desperate cross-country misadventure, all in the name of Love. Hilarious, flamboyant, heart-breaking and full of ingenious word play, Lolita is an immaculate, unforgettable masterpiece of obsession, delusion and lust. "));
        books2.add(new Book("The Brothers Karamazov ","Fyodor Dostoyevsky","https://images-na.ssl-images-amazon.com/images/I/71OZJsgZzQL.jpg","The Brothers Karamazov is a murder mystery, a courtroom drama, and an exploration of erotic rivalry in a series of triangular love affairs involving the “wicked and sentimental” Fyodor Pavlovich Karamazov and his three sons―the impulsive and sensual Dmitri; the coldly rational Ivan; and the healthy, red-cheeked young novice Alyosha. Through the gripping events of their story, Dostoevsky portrays the whole of Russian life, is social and spiritual striving, in what was both the golden age and a tragic turning point in Russian culture.\n" +
                "\n" +
                "This award-winning translation by Richard Pevear and Larissa Volokhonsky remains true to the verbal\n" +
                "inventiveness of Dostoevsky’s prose, preserving the multiple voices, the humor, and the surprising modernity of the original. It is an achievement worthy of Dostoevsky’s last and greatest novel."));
        books2.add(new Book("Crime and Punishment ","Fyodor Dostoyevsky","https://images-na.ssl-images-amazon.com/images/I/81b6e-dc41L.jpg","Raskolnikov, a destitute and desperate former student, wanders through the slums of St Petersburg and commits a random murder without remorse or regret. He imagines himself to be a great man, a Napoleon: acting for a higher purpose beyond conventional moral law. But as he embarks on a dangerous game of cat and mouse with a suspicious police investigator, Raskolnikov is pursued by the growing voice of his conscience and finds the noose of his own guilt tightening around his neck. Only Sonya, a downtrodden sex worker, can offer the chance of redemption."));
        books2.add(new Book("Wuthering Heights ","Emily Brontë","https://images-na.ssl-images-amazon.com/images/I/71ogwlE3YNL.jpg","This best-selling Norton Critical Edition is based on the 1847 first edition of the novel. For the Fourth Edition, the editor has collated the 1847 text with several modern editions and has corrected a number of variants, including accidentals. The text is accompanied by entirely new explanatory annotations.\n" +
                "\n" +
                "New to the fourth Edition are twelve of Emily Bronte's letters regarding the publication of the 1847 edition of Wuthering Heights as well as the evolution of the 1850 edition, prose and poetry selections by the author, four reviews of the novel, and poetry selections by the author, four reviews of the novel, and Edward Chitham's insightful and informative chronology of the creative process behind the beloved work.\n" +
                "\n" +
                "Five major critical interpretations of Wuthering Heights are included, three of them new to the Fourth Edition. A Stuart Daley considers the importance of chronology in the novel. J. Hillis Miller examines Wuthering Heights's problems of genre and critical reputation. Sandra M. Gilbert assesses the role of Victorian Christianity plays in the novel, while Martha Nussbaum traces the novel's romanticism. Finally, Lin Haire-Sargeant scrutinizes the role of Heathcliff in film adaptations of Wuthering Heights.\n" +
                "\n" +
                "A Chronology and updated Selected Bibliography are also included. "));



        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);

        //to create the database at the first time the app get launched
        boolean x=databaseHelper.doesDatabaseExist(this,"Book.db");
        if(!x)
        {
            Book book;
            try {
                book=new Book(-1,"In Search of Lost Time","Marcel Proust", "https://kbimages1-a.akamaihd.net/e3b6cfa6-190a-4ddf-aeb4-2d8bce850544/1200/1200/False/in-search-of-lost-time-21.jpg","In Search of Lost Time, also translated as Remembrance of Things Past, novel in seven parts by Marcel Proust, published in French as À la recherche du temps perdu from 1913 to 1927. The novel is the story of Proust's own life, told as an allegorical search for truth.");

            }
            catch(Exception e)
            {
                book=new Book(-1,"error","error","error","error");
            }
            databaseHelper=new DatabaseHelper(MainActivity.this);
            databaseHelper.addOne(book);

            for(int i=0;i<books2.size();i++)
            {

                Book book2;
                try {
                    book2=books2.get(i);
                }
                catch(Exception e)
                {
                    book2=new Book("error","error","error","error");
                }

                databaseHelper=new DatabaseHelper(MainActivity.this);
                databaseHelper.addOne(book2);

            }

        }


    }

    @Override
    public void onClick(View view) {


        switch(view.getId())
        {
            case R.id.btn1:
                intent=new Intent(MainActivity.this,AllBooksActivity.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                intent=new Intent(MainActivity.this,CurrentlyReadingActivity.class);
                startActivity(intent);
                break;
            case R.id.btn3:
                intent=new Intent(MainActivity.this,WantToReadActivity.class);
                startActivity(intent);
                break;
            case R.id.btn4:
                intent=new Intent(MainActivity.this,FavouriteActivity.class);
                startActivity(intent);
                break;
            case R.id.btn5:
                intent=new Intent(MainActivity.this,AlreadyReadBooksActivity.class);
                startActivity(intent);
                break;
            case R.id.btn6:

                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("this app is developed by Mohamed Raafat .for more info, visit our website");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      //leave this empty
                    }
                });
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intent=new Intent(MainActivity.this,AboutActivity.class);
                        startActivity(intent);
                    }
                });
                builder.create().show();
                break;
            default:break;

        }

    }
}