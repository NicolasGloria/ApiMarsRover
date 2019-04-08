package com.abaenglish.marsRover.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MarsRoverUtils {

	static List<String> textList = Arrays.asList(
			"Have you ever dreamed of running a bookshop? You can have a go for a week at the Open Book Store in Wigton, Scotland. In fact, if you book a holiday at the self-catering flat on Airbnb, you also have to work for 40 hours in the bookshop downstairs. A week in the flat costs £150. You won’t get paid for working, but you can use your own creative ideas to sell books and gain valuable experience. Wigton is Scotland’s national book town and this new venture is attracting interest from all over the world.",
			"Few people would choose a prison as the location for a special evening out. However, Italy has launched its first restaurant to be located in a real jail.  At the Ingalera Restaurant in Bollate prison, Milan, there are four prisoners working as waiters and five others cooking in the kitchen, headed by a professional chef and a maître. It is a ground-breaking project, which allows prisoners to be gradually included into society. The reataurant has had great reviews: everyone says the food is worth going to prison for.",
			"Grannies are very important for female elephants. A Behavioural Psychologist at the University of Stirling has been studying elephant herds in Kenya for decades. Her studies have found that the survival of female elephants and their success at reproducing is helped not only by having a mum but also by having a grandma. Female elephants support each other and protect and care for calves as a group and the grandmothers play an important role.  Elephants and girls should never forget their gran.",
			"A recent survey by the National Association of Professional Organizers reveals that 54% of Americans feel overwhelmed by clutter and 78% have no idea what to do with it. According to psychologists, people accumulate things because they are unhappy but having too many posessions brings stress and more unhappiness. Minimalists say you can live better if you focus only on what’s really important and get rid of your excess stuff. You can donate things you don’t need to charity. Minimalism is not new. Some of the ancient Greek philosophers were advocates, as were Mahatma Gandhi and Leo Tolstoy. There may be more joy in owning less than in constantly accumulating more.",
			"A Scottish PE teacher has invented a new fitness craze, which is rapidly catching on. The Highland Hustle is a mix of Scottish Highland dancing, ceilidh steps and muscle toning exercises.   Of course, it is also accompanied by fast funky music. At present, there is only one class, in Scotland, but there are several workout videos that can be downloaded from the official website. The routines, which last just half an hour, are designed for busy people with any fitness level. The workout promises to improve your level of fitness, but it will not teach you to be a highland dancer."
			);
	
	public static String getRandomText() {
		Random rand = new Random();
	    return textList.get(rand.nextInt(textList.size()));
	}
}
