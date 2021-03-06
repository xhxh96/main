package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

import javafx.scene.layout.VBox;
import seedu.address.model.person.Person;

/**
 * The Info Panel of the App.
 */
public class InfoPanel extends UiPart<Region> {
    private static final String FXML = "InfoPanel.fxml";
    private Person person;

    @FXML
    private ScrollPane infoScrollPane;
    @FXML
    private AnchorPane additionalInfo;
    @FXML
    private AnchorPane medHistory;
    @FXML
    private AnchorPane medAppts;
    @FXML
    private AnchorPane medReports;

    @FXML
    private Label nameLabel1;
    @FXML
    private Label nameLabel2;
    @FXML
    private Label nameLabel3;
    @FXML
    private Label nameLabel4;

    // Additional Info Pane
    @FXML
    private Label fullNameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label dateOfBirthLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label nricLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label heightLabel;
    @FXML
    private Label genderLabel;
    @FXML
    private Label bloodTypeLabel;
    @FXML
    private Label occupationLabel;
    @FXML
    private Label maritalStatusLabel;

    @FXML
    private Label fullNameTag;
    @FXML
    private Label nricTag;
    @FXML
    private Label dateOfBirthTag;
    @FXML
    private Label addressTag;
    @FXML
    private Label phoneTag;
    @FXML
    private Label heightTag;
    @FXML
    private Label weightTag;
    @FXML
    private Label genderTag;
    @FXML
    private Label emailTag;
    @FXML
    private Label bloodTypeTag;
    @FXML
    private Label occupationTag;
    @FXML
    private Label maritalStatusTag;

    @FXML
    private VBox medHistoryVBox;
    @FXML
    private VBox apptsVBox;
    @FXML
    private VBox medReportsVBox;

    public InfoPanel() {
        super(FXML);
    }

    public void setPerson(Person person) {
        this.person = person;

        initialiseNameLabels();
        fillAdditionalInfoPane();
        fillMedHistoriesPane();
        fillApptsPane();
        fillMedReportsPane();
    }

    /**
     * Initialises the name labels in all anchor panes
     */
    private void initialiseNameLabels() {
        nameLabel1.setText("Additional Info for " + person.getName());
        nameLabel2.setText("Medical History for " + person.getName());
        nameLabel3.setText("Appt Timetable for " + person.getName());
        nameLabel4.setText("Medical Reports for " + person.getName());
    }

    /**
     * Initialize Additional Information labels
     */
    private void fillAdditionalInfoPane() {
        additionalInfo.setStyle("-fx-background-color: #FCFCFC");

        fullNameTag.setText("Full Name:");
        nricTag.setText("NRIC:");
        dateOfBirthTag.setText("Date of Birth:");
        addressTag.setText("Address:");
        phoneTag.setText("Phone:");
        heightTag.setText("Height:");
        weightTag.setText("Weight:");
        genderTag.setText("Gender:");
        emailTag.setText("Email:");
        bloodTypeTag.setText("Blood Type:");
        occupationTag.setText("Occupation:");
        maritalStatusTag.setText("Marital Status:");

        fullNameLabel.setText(person.getName().fullName);
        emailLabel.setText(person.getEmail().value);
        nricLabel.setText(person.getNric().value);
        dateOfBirthLabel.setText(person.getDateOfBirth().toString() + "\t" + person.getDateOfBirth().ageToString());
        addressLabel.setText(person.getAddress().value);
        phoneLabel.setText(person.getPhone().value);
        heightLabel.setText(person.getHeight().value);
        weightLabel.setText(person.getWeight().value);
        genderLabel.setText(person.getGender().toString());
        bloodTypeLabel.setText(person.getBloodType().value);
        occupationLabel.setText(person.getOccupation().value);
        maritalStatusLabel.setText(person.getMaritalStatus().toString());
    }

    /**
     * Initialize Medical History Flow Pane
     */
    private void fillMedHistoriesPane() {
        medHistory.setStyle("-fx-background-color: #ECECEC");
        person.getMedHistory().forEach(medHistory ->
                medHistoryVBox.getChildren().add(new MedHistoryCard(medHistory)));
    }

    /**
     * Initialize Medical Appointment Flow Pane
     */
    private void fillApptsPane() {
        medAppts.setStyle("-fx-background-color: #DCDCDC");
        person.getAppts().forEach(appt -> apptsVBox.getChildren().add(new ApptCard(appt)));
    }

    /**
     * Initialize Medical Report Flow Pane
     */
    private void fillMedReportsPane() {
        medReports.setStyle("-fx-background-color: #CCCCCC");
        person.getMedicalReports().forEach(report ->
                medReportsVBox.getChildren().add(new ReportCard(report)));
    }

    /**
     * Empties vboxes in all anchorpanes
     */
    public void clearVBoxes() {
        medHistoryVBox.getChildren().clear();
        medReportsVBox.getChildren().clear();
        apptsVBox.getChildren().clear();
    }

    /**
     * Shows a message when there is no person card selected to tell the user to select a person
     */
    public void showEmptyMessage() {
        additionalInfo.setStyle("-fx-background-color: #FFFFFF");
        medHistory.setStyle("-fx-background-color: #FFFFFF");
        medAppts.setStyle("-fx-background-color: #FFFFFF");
        medReports.setStyle("-fx-background-color: #FFFFFF");
        nameLabel1.setText("You have not selected any person.\n"
                + "Please select a person to show more details\nfor him/her on this panel.");
        nameLabel2.setText("DATA PROTECTION NOTICE\n"
                + "This Data Protection Notice (“Notice”) sets out the basis which Health Book"
                + "(“we”, “us”, “our”)\n"
                + "may collect, use, disclose or otherwise process personal data of our customers in accordance with\n"
                + "the Personal Data Protection Act (“PDPA”). This Notice applies to personal data in"
                + "our possession\n"
                + "or under our control, including personal data in the possession of organisations which we have\n"
                + "engaged to collect, use, disclose or process personal data for our purposes.\n"
                + "PERSONAL DATA\n"
                + "1. As used in this Notice:\n"
                + "“customer” means an individual who (a) has contacted us through any means to find out more\n"
                + "about any goods or services we provide, or (b) may, or has, entered into a contract with us for\n"
                + "the supply of any goods or services by us; and\n"
                + "“personal data” means data, whether true or not, about a customer who can be identified:\n"
                + "(a) from that data; or (b) from that data and other information to which we have or are likely\n"
                + "to have access.\n"
                + "2. Depending on the nature of your interaction with us, some examples of personal data which\n"
                + "we may collect from you include your name and identification information such as your NRIC\n"
                + "number, contact information such as your address, email address or telephone number,\n"
                + "nationality, gender, date of birth, marital status, photographs and other audio-visual\n"
                + "information, employment information and financial information such as credit card numbers,\n"
                + "debit card numbers or bank account information.\n"
                + "3. Other terms used in this Notice shall have the meanings given to them in the PDPA (where the\n"
                + "context so permits)."
                + "COLLECTION, USE AND DISCLOSURE OF PERSONAL DATA\n"
                + "4. We do not collect your personal data unless (a) it is provided to us voluntarily by you\n"
                + "directly or via a third party who has been duly authorised by you to disclose your personal\n"
                + "data to us (your “authorised representative”) after "
                + "(i) you (or your authorised representative)\n"
                + "have been notified of the purposes for which the data is collected, and (ii) you (or your\n"
                + "authorised representative) have provided written consent to the collection and usage of your\n"
                + "personal data for those purposes, or (b) collection and use of personal data without consent\n"
                + "is permitted or required by the PDPA or other laws. We shall seek your consent before\n"
                + "collecting any additional personal data and before using your personal data for a purpose\n"
                + "which has not been notified to you (except where permitted or authorised by law).\n"
                + "5. We may collect and use your personal data for any or all of the following purposes:\n"
                + "(a) performing obligations in the course of or in connection with our provision of the\n"
                + "goods and/or services requested by you;\n"
                + "(b) verifying your identity;\n"
                + "(c) responding to, handling, and processing queries, requests, applications, complaints,\n"
                + "and feedback from you; "
                + "(d) managing your relationship with us;\n"
                + "(e) processing payment or credit transactions;\n"
                + "(f) sending your marketing information about our goods or services including notifying\n"
                + "you of our marketing events, initiatives and promotions, lucky draws, membership\n"
                + "and rewards schemes and other promotions;\n"
                + "(g) complying with any applicable laws, regulations, codes of practice, guidelines, or rules,\n"
                + "or to assist in law enforcement and investigations conducted by any governmental\n"
                + "and/or regulatory authority;\n"
                + "(h) any other purposes for which you have provided the information;\n"
                + "(i) transmitting to any unaffiliated third parties including our third party service\n"
                + "providers and agents, and relevant governmental and/or regulatory authorities,\n"
                + "whether in Singapore or abroad, for the aforementioned purposes; and\n"
                + "(j) any other incidental business purposes related to or in connection with the above.\n"
                + "6. We may disclose your personal data:\n"
                + "(a) where such disclosure is required for performing obligations in the course of or in\n"
                + "connection with our provision of the goods or services requested by you; or\n"
                + "(b) to third party service providers, agents and other organisations we have engaged to\n"
                + "perform any of the functions listed in clause 5 above for us. \n"
                + "7. The purposes listed in the above clauses may continue to apply even in situations where your\n"
                + "relationship with us (for example, pursuant to a contract) has been terminated or altered in\n"
                + "any way, for a reasonable period thereafter (including, where applicable, a period to enable\n"
                + "us to enforce our rights under any contract with you).\n"
                + "WITHDRAWING YOUR CONSENT\n"
                + "8. The consent that you provide for the collection, use and disclosure of your personal data will\n"
                + "remain valid until such time it is being withdrawn by you in writing. You may withdraw consent\n"
                + "and request us to stop using and/or disclosing your personal data for any or all of the purposes\n"
                + "listed above by submitting your request in writing or via email to our Data Protection Officer\n"
                + "at the contact details provided below.\n"
                + "9. Upon receipt of your written request to withdraw your consent, we may require reasonable\n"
                + "time (depending on the complexity of the request and its impact on our relationship with you)\n"
                + "for your request to be processed and for us to notify you of the consequences of us acceding\n"
                + "to the same, including any legal consequences which may affect your rights and liabilities to\n"
                + "us. In general, we shall seek to process your request within ten (10) business days of receiving\n"
                + "it.\n"
                + "10. Whilst we respect your decision to withdraw your consent, please note that depending on the\n"
                + "nature and scope of your request, we may not be in a position to continue providing our goods "
                + "or services to you and we shall, in such circumstances, notify you before completing the\n"
                + "processing of your request. Should you decide to cancel your withdrawal of consent, please\n"
                + "inform us in writing in the manner described in clause 8 above.\n"
                + "11. Do note that withdrawing consent does not affect our right to continue to collect, use and\n"
                + "disclose personal data where such collection, use and disclose without consent is permitted\n"
                + "or required under applicable laws.\n"
                + "ACCESS TO AND CORRECTION OF PERSONAL DATA\n"
                + "12. If you wish to make (a) an access request for access to a copy of the personal data which we\n"
                + "hold about you or information about the ways in which we use or disclose your personal data,\n"
                + "or (b) a correction request to correct or update any of your personal data which we hold about\n"
                + "you, you may submit your request in writing or via email to our Data Protection Officer at the\n"
                + "contact details provided below.\n"
                + "13. Please note that a reasonable fee may be charged for an access request. If so, we will inform\n"
                + "you of the fee before processing your request.\n"
                + "14. We will respond to your request as soon as reasonably possible. Should we not be able to\n"
                + "respond to your request within thirty (30) days after receiving your request, we will inform\n"
                + "you in writing within thirty (30) days of the time by which we will be able to respond to your\n"
                + "request. If we are unable to provide you with any personal data or to make a correction\n"
                + "requested by you, we shall generally inform you of the reasons why we are unable to do so\n"
                + "(except where we are not required to do so under the PDPA). \nPROTECTION OF PERSONAL DATA\n"
                + "15. To safeguard your data from unauthorised access, collection, use, disclosure, copying,\n"
                + "modification, disposal or similar risks, we have introduced appropriate administrative,\n"
                + "physical and technical measures such as up-to-date antivirus protection, encryption and the\n"
                + "use of privacy filters to secure all storage and transmission of personal data by us, and\n"
                + "disclosing personal data both internally and to our authorised third party service providers\n"
                + "and agents only on a need-to-know basis.\n"
                + "16. You should be aware, however, that no method of transmission over the Internet or method\n"
                + "of electronic storage is completely secure. While security cannot be guaranteed, we strive to\n"
                + "protect the security of your information and are constantly reviewing and enhancing our\n"
                + "information security measures.\n"
                + "ACCURACY OF PERSONAL DATA\n"
                + "17. We generally rely on personal data provided by you (or your authorised representative). In\n"
                + "order to ensure that your personal data is current, complete and accurate, please update us\n"
                + "if there are changes to your personal data by informing our Data Protection Officer in writing\n"
                + "or via email at the contact details provided below.\n"
                + "RETENTION OF PERSONAL DATA\n"
                + "18. We may retain your personal data for as long as necessary to fulfil the purpose for which\n"
                + "it was collected, or as required or permitted by applicable laws."
                + "19. We will cease to retain your personal data, or remove the means by which the data can be\n"
                + "associated with you, as soon as it is reasonable to assume that such retention no longer serves\n"
                + "the purpose for which the personal data was collected, and is no longer necessary for legal or\n"
                + "business purposes.\n"
                + "TRANSFERS OF PERSONAL DATA OUTSIDE OF SINGAPORE\n"
                + "20. We generally do not transfer your personal data to countries outside of Singapore. However,\n"
                + "if we do so, we will obtain your consent for the transfer to be made and we will take steps to\n"
                + "ensure that your personal data continues to receive a standard of protection that is at least\n"
                + "comparable to that provided under the PDPA.\n"
                + "DATA PROTECTION OFFICER\n"
                + "21. You may contact our Data Protection Officer if you have any enquiries or feedback on our\n"
                + "personal data protection policies and procedures, or if you wish to make any request, in the\n"
                + "following manner:\n"
                + "[Mr David Tan 91234567 davidtan@hotmail.com]."
                + "EFFECT OF NOTICE AND CHANGES TO NOTICE\n"
                + "22. This Notice applies in conjunction with any other notices, contractual clauses and consent\n"
                + "clauses that apply in relation to the collection, use and disclosure of your personal data by us.\n"
                + "23. We may revise this Notice from time to time without any prior notice. You may determine if\n"
                + "any such revision has taken place by referring to the date on which this Notice was last\n"
                + "updated. Your continued use of our services constitutes your acknowledgement and\n"
                + "acceptance of such changes.\n"
                + "Effective date : 06-11-2018\n"
                + "Last updated : 06-11-2018\n"
                + "ACKNOWLEDGEMENT AND CONSENT\n"
                + "I acknowledge that I have read and understood the [above Data Protection Notice], and consent to\n"
                + "the collection, use and disclosure of my personal data by Health Book for the purposes set\n"
                + "out in the Notice. \n");
        nameLabel3.setText("");
        nameLabel4.setText("");

        fullNameTag.setText("");
        nricTag.setText("");
        dateOfBirthTag.setText("");
        addressTag.setText("");
        phoneTag.setText("");
        heightTag.setText("");
        weightTag.setText("");
        genderTag.setText("");
        emailTag.setText("");
        bloodTypeTag.setText("");
        occupationTag.setText("");
        maritalStatusTag.setText("");

        fullNameLabel.setText("");
        emailLabel.setText("");
        nricLabel.setText("");
        dateOfBirthLabel.setText("");
        addressLabel.setText("");
        phoneLabel.setText("");
        heightLabel.setText("");
        weightLabel.setText("");
        genderLabel.setText("");
        bloodTypeLabel.setText("");
        occupationLabel.setText("");
        maritalStatusLabel.setText("");
    }
}
