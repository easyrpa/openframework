package files_manipulations.task;

import com.google.api.services.drive.model.File;
import eu.ibagroup.easyrpa.engine.annotation.ApTaskEntry;
import eu.ibagroup.easyrpa.engine.apflow.ApTask;
import eu.ibagroup.easyrpa.openframework.googledrive.GoogleDrive;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.Optional;

@Slf4j
@ApTaskEntry(name = "Rename File")
public class RenameFile extends ApTask {

    private static final String fileName = "myFile";

    @Inject
    private GoogleDrive drive;

    public void execute() {
        log.info("Getting file '{}' from google drive", fileName);
        Optional<File> file = drive.getFileByName(fileName);

        if (file.isPresent()) {
            boolean result = drive.renameFile(file.get(), "RenamedFile");
            if (result) {
                log.info("File successfully renamed");
            } else{
                log.info("Error during renaming file");
            }
        } else {
            log.info("There were some error during getting file");
        }
    }
}