package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_HISTORY_ALLERGY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_HISTORY_COUNTRY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_HISTORY_DATE;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import seedu.address.logic.commands.AddHistCommand;
import seedu.address.model.medhistory.MedHistory;

/**
 * A utility class for MedicalReport.
 */
public class MedHistoryUtil {
    /**
     * Returns an add command string for adding the {@code person}.
     */
    public static String getAddHistCommand(MedHistory medHistory) {
        return AddHistCommand.COMMAND_WORD + " " + INDEX_FIRST_PERSON.getOneBased() + " "
                + getMedHistoryDetails(medHistory);
    }

    /**
     * Returns the part of command string for the given {@code appt}'s details.
     */
    public static String getMedHistoryDetails(MedHistory medHistory) {
        StringBuilder sb = new StringBuilder();
        medHistory.getMedHistDate().ifPresent(
                medHistDate -> sb.append(PREFIX_HISTORY_DATE).append(medHistDate.value).append(" "));
        medHistory.getAllergy().ifPresent(
                allergy -> sb.append(PREFIX_HISTORY_ALLERGY).append(allergy.value).append(" "));
        medHistory.getPrevCountry().ifPresent(
                prevCountry -> sb.append(PREFIX_HISTORY_COUNTRY).append(prevCountry.value).append(" "));
        return sb.toString();
    }
}
