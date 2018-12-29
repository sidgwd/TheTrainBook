package trainboook.hack.com.thetrainbook.Customs;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.UUID;

/*
 * Created by Anton Bevza on 1/13/17.
 */
abstract class FixturesData {

    static SecureRandom rnd = new SecureRandom();

    static ArrayList<String> avatars = new ArrayList<String>() {
        {
            add("http://i.imgur.com/pv1tBmT.png");
            add("https://firebasestorage.googleapis.com/v0/b/fitness-gym-39f09.appspot.com/o/hacka%2Fsid.jpg?alt=media&token=67a73950-386e-4b23-8eb9-f7b1479db054");
            add("http://i.imgur.com/ROz4Jgh.png");
            add("http://i.imgur.com/Qn9UesZ.png");
        }
    };

    static final ArrayList<String> groupChatImages = new ArrayList<String>() {
        {
            add("http://i.imgur.com/hRShCT3.png");
            add("http://i.imgur.com/zgTUcL3.png");
            add("http://i.imgur.com/mRqh5w1.png");
        }
    };

    static final ArrayList<String> groupChatTitles = new ArrayList<String>() {
        {
            add("Amit");
            add("Siddhesh");
            add("Smita");
        }
    };

    static final ArrayList<String> names = new ArrayList<String>() {
        {
            add("Amit");
            add("Siddhesh");
            add("Nitin");
            add("Smita");
            add("Ashish");
            add("Chaitali");
            add("Jordon");
            add("Nilesh");
            add("Raju");
            add("Vishal");
            add("Pratik");
        }
    };

    static final ArrayList<String> messages = new ArrayList<String>() {
        {
            add("Hello!");
            add("This is my phone number - +1 (234) 567-89-01");
            add("Here is my e-mail - myemail@example.com");
            add("Hey! Check out this awesome app! M-indicator");
            add("Hello! No problem. I can today at 2 pm. And after we can go to the office.");
            add("At first, for some time, I was not able to answer him one word");
            add("At length one of them called out in a clear, polite, smooth dialect, not unlike in sound to the Italian");
            add("By the bye, Rakesh, said Ankit");
            add("He made his passenger captain of one, with four of the men; and himself, his mate, and five more, went in the other; and they contrived their business very well, for they came up to the ship about midnight.");
            add("So saying he unbuckled his baldric with the bugle");
            add("Just then her head struck against the roof of the hall: in fact she was now more than nine feet high, and she at once took up the little golden key and hurried off to the garden door.");
        }
    };

    static final ArrayList<String> images = new ArrayList<String>() {
        {
            add("https://firebasestorage.googleapis.com/v0/b/fitness-gym-39f09.appspot.com/o/hacka%2F1234dd.jpg?alt=media&token=cef10b95-2189-4087-9704-5566877e0439");
            add("https://firebasestorage.googleapis.com/v0/b/fitness-gym-39f09.appspot.com/o/hacka%2Fdadar.jpeg?alt=media&token=33c9c733-3aae-4cd9-9776-291e1cae1c0d");
            add("https://firebasestorage.googleapis.com/v0/b/fitness-gym-39f09.appspot.com/o/hacka%2Fimage1.jpg?alt=media&token=cfaf1bdc-399d-48dc-82dd-2c79a3c27340");
            add("https://firebasestorage.googleapis.com/v0/b/fitness-gym-39f09.appspot.com/o/hacka%2Fmaxresdefault.jpg?alt=media&token=1d396e30-cbc5-46ff-abd5-623d915f3fda");
            add("https://firebasestorage.googleapis.com/v0/b/fitness-gym-39f09.appspot.com/o/hacka%2Fmaxresdefault.jpg?alt=media&token=ad8a46cc-026d-4d76-9c35-2323d1bed9aa");
            add("https://firebasestorage.googleapis.com/v0/b/fitness-gym-39f09.appspot.com/o/hacka%2FRailways_Reuters.jpeg?alt=media&token=10f741be-c34d-48f8-a1a8-fede32dd3d78");
        }
    };

    static String getRandomId() {
        return Long.toString(UUID.randomUUID().getLeastSignificantBits());
    }

    static String getRandomAvatar() {
        return avatars.get(rnd.nextInt(avatars.size()));
    }

    static String getRandomGroupChatImage() {
        return groupChatImages.get(rnd.nextInt(groupChatImages.size()));
    }

    static String getRandomGroupChatTitle() {
        return groupChatTitles.get(rnd.nextInt(groupChatTitles.size()));
    }

    static String getRandomName() {
        return names.get(rnd.nextInt(names.size()));
    }

    static String getRandomMessage() {
        return messages.get(rnd.nextInt(messages.size()));
    }

    static String getRandomImage() {
        return images.get(rnd.nextInt(images.size()));
    }

    static boolean getRandomBoolean() {
        return rnd.nextBoolean();
    }
}
