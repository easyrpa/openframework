package eu.ibagroup.easyrpa.examples.googlesheets.working_with_merged_cells.tasks;

import eu.ibagroup.easyrpa.engine.annotation.ApTaskEntry;
import eu.ibagroup.easyrpa.engine.annotation.Configuration;
import eu.ibagroup.easyrpa.engine.apflow.ApTask;
import eu.ibagroup.easyrpa.openframework.googlesheets.Cell;
import eu.ibagroup.easyrpa.openframework.googlesheets.GoogleSheets;
import eu.ibagroup.easyrpa.openframework.googlesheets.Sheet;
import eu.ibagroup.easyrpa.openframework.googlesheets.SpreadsheetDocument;
import eu.ibagroup.easyrpa.openframework.googlesheets.constants.HorizontalAlignment;
import eu.ibagroup.easyrpa.openframework.googlesheets.constants.VerticalAlignment;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;

@ApTaskEntry(name = "Merge Unmerge Cells")
@Slf4j
public class MergeUnmergeCells extends ApTask {

    @Configuration(value = "spreadsheet.id")
    private String spreadsheetId;

    @Configuration(value = "sheet.name")
    private String sheetName;

    @Inject
    GoogleSheets service;

    @Override
    public void execute() {
        String cellRegionToMerge = "A1:D4";
        String cellRegionToUnMerge = "E2:G4";

        log.info("Open sheet with the name '{}' in the document with id '{}'.", sheetName, spreadsheetId);
        SpreadsheetDocument doc = service.getSpreadsheet(spreadsheetId);
        Sheet activeSheet = doc.getSheet(sheetName);

        log.info("Merge cells '{}' on sheet '{}'.", cellRegionToMerge, activeSheet.getName());
        Cell topLeftCellOfMergedRegion = activeSheet.mergeCells(cellRegionToMerge);

        topLeftCellOfMergedRegion.getStyle().horizontalAlignment(HorizontalAlignment.CENTER).verticalAlignment(VerticalAlignment.MIDDLE);

        log.info("Unmerge cells '{}'.", cellRegionToUnMerge);
        activeSheet.unmergeCells(cellRegionToUnMerge);

        log.info("Spreadsheet document is saved successfully.");
    }
}
