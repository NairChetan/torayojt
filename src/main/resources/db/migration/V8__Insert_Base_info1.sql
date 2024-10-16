INSERT INTO BASE_INFO ("CRT_TIMESTAMP", "CRT_USERID", "UPD_TIMESTAMP", "UPD_USERID", "SEQ_INFO", "BEGIN_YMD", "END_YMD", "IMPORTANT_FLG", "TITLE", "TEXT")
VALUES (SYSTIMESTAMP, 'admin1', SYSTIMESTAMP, 'admin1', 1005, TO_DATE('2024-01-01', 'YYYY-MM-DD'), TO_DATE('2024-12-31', 'YYYY-MM-DD'), 'Y', 'Annual Summary', 'This is the annual summary report for the year.');

INSERT INTO BASE_INFO ("CRT_TIMESTAMP", "CRT_USERID", "UPD_TIMESTAMP", "UPD_USERID", "SEQ_INFO", "BEGIN_YMD", "END_YMD", "IMPORTANT_FLG", "TITLE", "TEXT")
VALUES (SYSTIMESTAMP, 'manager1', SYSTIMESTAMP, 'manager1', 1006, TO_DATE('2024-03-15', 'YYYY-MM-DD'), TO_DATE('2024-11-15', 'YYYY-MM-DD'), 'N', 'Quarterly Review', 'Details about the quarterly performance review.');
