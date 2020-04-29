# Ingeniería de Software - Examen Parcial 2

Segundo examen parcial del curso Ingeniería de Software.

## Endpoints

### CU01 - Importar estudiantes desde archivo XLSX
- http://localhost:9097/import/fromxlsx

### CU02 - Exportar estudiantes a archivo XLSX
- http://localhost:9097/export/toxlsx?name=%pepito%

### CU03 - Importar estudiantes desde archivo XLSX en FTP
- http://localhost:9097/import/fromftp?filename=lista1.xlsx

### CU04 - Exportar estudiantes a archivo XLSX en FTP
- http://localhost:9097/export/toftp?name=%pepito%

### CU05 - Asignar estudiantes de forma manual
- http://localhost:9097/assignments/assign?student=%juan%&course=math%

### CU06 - Desasignar estudiantes de forma manual
- http://localhost:9097/assignments/deallocate?student=%juan%&course=math%

### CU07 - Asignar automáticamente cada 5 minutos
- N/A

### CU08 - Consultar estudiantes por página
- http://localhost:9097/student/lazyLoad?page=4&size=70

### CU09 - Generar dashboard XLSX
- http://localhost:9097/export/dashboard/dash20200427

### CU10 - Eliminar registros por lote
- http://localhost:9097/purge/students/field?value=%garc%&batchsize=100
