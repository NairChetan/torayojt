INSERT INTO BASE_PARTY_ACCOUNT
(
    PARTY_ID, ACCOUNT_ID, ACCOUNT_PASSWORD, STATE, EXP_DATE,
    FAILED_LOGIN_COUNT, UPD_TIMESTAMP, UPD_USERID,
    FAILED_LOGIN_ATTEMPTS, ACCOUNT_KIND, LAST_LOGIN_DATE,
    CRT_TIMESTAMP, CRT_USERID, DATA_UPD_TIMESTAMP, DATA_UPD_USERID, EMAIL_LOGIN_STATE
)
VALUES
(
    'P12345', 'A12345', 'cGFzc3dvcmRIYXNoMQ==', 'A', TO_DATE('2024-12-31', 'YYYY-MM-DD'),
    0, SYSTIMESTAMP, 'USER1',
    0, 'STANDARD', SYSTIMESTAMP,
    SYSTIMESTAMP, 'USER1', SYSTIMESTAMP, 'USER1', 'Y'
);
INSERT INTO BASE_PARTY_ACCOUNT
(
    PARTY_ID, ACCOUNT_ID, ACCOUNT_PASSWORD, STATE, EXP_DATE,
    FAILED_LOGIN_COUNT, UPD_TIMESTAMP, UPD_USERID,
    FAILED_LOGIN_ATTEMPTS, ACCOUNT_KIND, LAST_LOGIN_DATE,
    CRT_TIMESTAMP, CRT_USERID, DATA_UPD_TIMESTAMP, DATA_UPD_USERID, EMAIL_LOGIN_STATE
)
VALUES
(
      'P67890', 'A67890', 'cGFzc3dvcmRIYXNoMg==', 'I', TO_DATE('2025-06-30', 'YYYY-MM-DD'),
      2, SYSTIMESTAMP, 'USER2',
      2, 'PREMIUM', SYSTIMESTAMP,
      SYSTIMESTAMP, 'USER2', SYSTIMESTAMP, 'USER2', 'N'
  );
