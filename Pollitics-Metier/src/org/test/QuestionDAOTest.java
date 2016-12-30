package org.test;

import java.util.List;

import org.com.pollitics.model.jpa.Question;
import org.com.pollitics.service.dao.QuestionDAO;

import junit.framework.TestCase;

public class QuestionDAOTest extends TestCase {

	public void testCreateQuestion() {

		try {
			Question question = new Question();
			question.setDailyQuestion("0");
			question.setType("JUNIT cr�ation question- Test cr�ation type");
			question.setWording("JUNIT cr�ation question- Test cr�ation libelle");

			QuestionDAO.getInstance().createObject(question);
		} catch (Exception e) {
			e.printStackTrace();
			assertFalse(e.getMessage(), true);
		}
	}

	public void testSelectDailyQuestion() {

		try {

			List<Question> questions = QuestionDAO.getInstance().selectAllQuestion();

			for (Question question : questions) {
				question.setDailyQuestion("0");
				QuestionDAO.getInstance().updateQuestion(question);
			}

			String questionType = "JUNIT cr�ation question daily- Test cr�ation type";
			String questionWording = "JUNIT cr�ation question daily- Test cr�ation libelle";

			Question question = new Question();
			question.setDailyQuestion("1");
			question.setType(questionType);
			question.setWording(questionWording);

			/** cr�ation de la question **/
			QuestionDAO.getInstance().createQuestion(question);

			/** r�cup�ration de la question quotidienne **/
			Question dailyQuestion = QuestionDAO.getInstance().selectDailyQuestion();
			assertEquals(questionType, dailyQuestion.getType());
			assertEquals(questionWording, dailyQuestion.getWording());

		} catch (Exception e) {
			e.printStackTrace();
			assertFalse(e.getMessage(), true);
		}
	}

	public void testSelectAllQuestion() {
		try {

			List<Question> questions = QuestionDAO.getInstance().selectAllQuestion();
			assertNotNull(questions);
			assertFalse(!questions.isEmpty());
		} catch (Exception e) {
			e.printStackTrace();
			assertFalse(e.getMessage(), true);
		}
	}
}
