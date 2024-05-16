import * as XLSX from "xlsx"

export default async function exportExcel(data){
    const workbook = XLSX.utils.book_new();
    const worksheet = XLSX.utils.aoa_to_sheet(data);
    XLSX.utils.book_append_sheet(workbook, worksheet, "framework");
    XLSX.writeFile(workbook, "excel.xlsx");
}
