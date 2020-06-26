package at.htl.entity;

import javax.persistence.*;

@Entity
@Table(name = "TRAFFIC")
public class Traffic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "T_ID")
    private Long id;

    @Column(name = "T_GER_WORD", length = 100)
    private String GERword;
    @Column(name = "T_EN_WORD", length = 100)
    private String ENword;
    @Column(name = "T_RIGT_WRONG", length = 50)
    private boolean rightOrWrong;
    @Column(name = "T_RIGHT_ANSW", length = 100)
    private String rightAnswer;
    @Column(name = "T_NUM_RIGHT_ANSW", length = 2)
    private int numberOfRightAnswers;
    @Column(name = "T_NUM_WRONG_ANSW", length = 2)
    private int numberOfWrongAnswers;

    public Traffic() {
    }

    public Traffic(Long id, String GERword, String ENword, boolean rightOrWrong, String rightAnswer, int numberOfRightAnswers, int numberOfWrongAnswers) {
        this.id = id;
        this.GERword = GERword;
        this.ENword = ENword;
        this.rightOrWrong = rightOrWrong;
        this.rightAnswer = rightAnswer;
        this.numberOfRightAnswers = numberOfRightAnswers;
        this.numberOfWrongAnswers = numberOfWrongAnswers;
    }

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getGERword() {
        return GERword;
    }

    public void setGERword(String GERword) {
        this.GERword = GERword;
    }

    public String getENword() {
        return ENword;
    }

    public void setENword(String ENword) {
        this.ENword = ENword;
    }

    public boolean isRightOrWrong() {
        return rightOrWrong;
    }

    public void setRightOrWrong(boolean rightOrWrong) {
        this.rightOrWrong = rightOrWrong;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public int getNumberOfRightAnswers() {
        return numberOfRightAnswers;
    }

    public void setNumberOfRightAnswers(int numberOfRightAnswers) {
        this.numberOfRightAnswers = numberOfRightAnswers;
    }

    public int getNumberOfWrongAnswers() {
        return numberOfWrongAnswers;
    }

    public void setNumberOfWrongAnswers(int numberOfWrongAnswers) {
        this.numberOfWrongAnswers = numberOfWrongAnswers;
    }

    @Override
    public String toString() {
        return "Traffic{" +
                "id=" + id +
                ", GERword='" + GERword + '\'' +
                ", ENword='" + ENword + '\'' +
                ", rightOrWrong=" + rightOrWrong +
                ", rightAnswer='" + rightAnswer + '\'' +
                ", numberOfRightAnswers=" + numberOfRightAnswers +
                ", numberOfWrongAnswers=" + numberOfWrongAnswers +
                '}';
    }
}
