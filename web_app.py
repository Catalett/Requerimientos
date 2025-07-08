import oracledb
import csv
import paramiko
import re
import os
from dotenv import load_dotenv

# Cargar del archivo .env
load_dotenv()

def query_to_csv(conn, output_file):
    query = """
        SELECT 
            LOCATION.SRLO_ITEM,
            ITEM.SRIT_CATEGORY,
            ITEM.SRIT_DESCRIPTION,
            LOCATION.SRLO_STORE,
            ITEM_SERIAL.SRIS_SERIAL_NUMBER
        FROM 
            COSWIN.LOCATION LOCATION
        JOIN 
            COSWIN.ITEM ITEM
        ON 
            ITEM.SRIT_CODE = LOCATION.SRLO_ITEM
        JOIN
            COSWIN.ITEM_SERIAL ITEM_SERIAL
        ON 
            ITEM_SERIAL.SRIS_ITEM = LOCATION.SRLO_ITEM
            AND ITEM_SERIAL.SRIS_SERIAL_NUMBER = LOCATION.SRLO_SERIAL_NUMBER
            
        WHERE 
            ITEM.SRIT_CODE IN ('FE-007','FE-005','FE-009','FE-017','FE-020','FE-026','FE-252','FE-327','FE-328','FE-329','FE-027','FE-030','FE-031','FE-035','FE-037','FE-039',
                               'FE-040','FE-044','FE-047','FE-048','FE-049','FE-050','FE-051','FE-052','FE-053','FE-054','FE-055','FE-056',
                               'FE-057','FE-058','FE-059','FE-060','FE-061','FE-062','FE-063','FE-064','FE-065','FE-070','FE-072','FE-073',
                               'FE-074','FE-075','FE-076','FE-077','FE-078','FE-079','FE-080','FE-105','FE-260','FE-269','FE-351')

        AND LOCATION.SRLO_FREE_QUANTITY = 1 
        AND ITEM_SERIAL.SRIS_STATUS = 0  
        AND NOT REGEXP_LIKE(ITEM_SERIAL.SRIS_SERIAL_NUMBER, '^(FAKE|REM|X|TEMP|TWMP)')
        AND LOCATION.SRLO_STORE <> 'OFF-SITE'
        ORDER BY 
            CASE 
                WHEN LOCATION.SRLO_ITEM = 'FE-047' THEN 1
                WHEN LOCATION.SRLO_ITEM = 'FE-048' THEN 2
                WHEN LOCATION.SRLO_ITEM = 'FE-049' THEN 3
                WHEN LOCATION.SRLO_ITEM = 'FE-050' THEN 4
                WHEN LOCATION.SRLO_ITEM = 'FE-051' THEN 5
                WHEN LOCATION.SRLO_ITEM = 'FE-052' THEN 6
                WHEN LOCATION.SRLO_ITEM = 'FE-053' THEN 7
                WHEN LOCATION.SRLO_ITEM = 'FE-054' THEN 8
                WHEN LOCATION.SRLO_ITEM = 'FE-055' THEN 9
                WHEN LOCATION.SRLO_ITEM = 'FE-056' THEN 10
                WHEN LOCATION.SRLO_ITEM = 'FE-057' THEN 11
                WHEN LOCATION.SRLO_ITEM = 'FE-058' THEN 12
                WHEN LOCATION.SRLO_ITEM = 'FE-059' THEN 13
                WHEN LOCATION.SRLO_ITEM = 'FE-060' THEN 14
                WHEN LOCATION.SRLO_ITEM = 'FE-061' THEN 15
                WHEN LOCATION.SRLO_ITEM = 'FE-062' THEN 16
                WHEN LOCATION.SRLO_ITEM = 'FE-063' THEN 17
                WHEN LOCATION.SRLO_ITEM = 'FE-064' THEN 18
                WHEN LOCATION.SRLO_ITEM = 'FE-065' THEN 19
                WHEN LOCATION.SRLO_ITEM = 'FE-040' THEN 20
                WHEN LOCATION.SRLO_ITEM = 'FE-269' THEN 21
                WHEN LOCATION.SRLO_ITEM = 'FE-005' THEN 22
                WHEN LOCATION.SRLO_ITEM = 'FE-007' THEN 23
                WHEN LOCATION.SRLO_ITEM = 'FE-009' THEN 24
                WHEN LOCATION.SRLO_ITEM = 'FE-017' THEN 25
                WHEN LOCATION.SRLO_ITEM = 'FE-020' THEN 26
                WHEN LOCATION.SRLO_ITEM = 'FE-026' THEN 27
                WHEN LOCATION.SRLO_ITEM = 'FE-252' THEN 28
                WHEN LOCATION.SRLO_ITEM = 'FE-327' THEN 29
                WHEN LOCATION.SRLO_ITEM = 'FE-328' THEN 30
                WHEN LOCATION.SRLO_ITEM = 'FE-329' THEN 31
                WHEN LOCATION.SRLO_ITEM = 'FE-027' THEN 32
                WHEN LOCATION.SRLO_ITEM = 'FE-030' THEN 33
                WHEN LOCATION.SRLO_ITEM = 'FE-031' THEN 34
                WHEN LOCATION.SRLO_ITEM = 'FE-035' THEN 35
                WHEN LOCATION.SRLO_ITEM = 'FE-037' THEN 36
                WHEN LOCATION.SRLO_ITEM = 'FE-039' THEN 37
                WHEN LOCATION.SRLO_ITEM = 'FE-044' THEN 38
                WHEN LOCATION.SRLO_ITEM = 'FE-070' THEN 39
                WHEN LOCATION.SRLO_ITEM = 'FE-072' THEN 40
                WHEN LOCATION.SRLO_ITEM = 'FE-073' THEN 41
                WHEN LOCATION.SRLO_ITEM = 'FE-074' THEN 42
                WHEN LOCATION.SRLO_ITEM = 'FE-075' THEN 43
                WHEN LOCATION.SRLO_ITEM = 'FE-076' THEN 44
                WHEN LOCATION.SRLO_ITEM = 'FE-077' THEN 45
                WHEN LOCATION.SRLO_ITEM = 'FE-078' THEN 46
                WHEN LOCATION.SRLO_ITEM = 'FE-079' THEN 47
                WHEN LOCATION.SRLO_ITEM = 'FE-080' THEN 48
                WHEN LOCATION.SRLO_ITEM = 'FE-105' THEN 49
                WHEN LOCATION.SRLO_ITEM = 'FE-260' THEN 50
                WHEN LOCATION.SRLO_ITEM = 'FE-351' THEN 51
            END
    """
     
    cursor = conn.cursor()
    cursor.execute(query)
    data = cursor.fetchall()

    if data:
        print(f"Total records: {len(data)}")
        
        # CSV
        with open(output_file, mode='w', newline='', encoding='utf-8') as file:
            writer = csv.writer(file)
            
            writer.writerow(["ITEM CODE", "CATEGORY", "DESCRIPTION", "STORE", "SERIAL NUMBER"])

            for row in data:
                writer.writerow(row)

        print(f"Data has been written to {output_file}")
        return output_file
    else:
        print("No data found.")
        return None

def upload_to_server(local_file, remote_path, hostname, port, username, password):
    """
    Sube un archivo al servidor externo mediante SFTP.
    """
    try:
        # SSH
        transport = paramiko.Transport((hostname, port))
        transport.connect(username=username, password=password)

        # SFTP
        sftp = paramiko.SFTPClient.from_transport(transport)

        # Sube archivo
        sftp.put(local_file, remote_path)
        print(f"File {local_file} uploaded to {remote_path} on {hostname}")
        
        # Cerrar 
        sftp.close()
        transport.close()
    except Exception as e:
        print("Error uploading file to server:")
        print(e)

def connectCMMS():
    try:
        
        db_user = os.getenv('DB_USER')
        db_password = os.getenv('DB_PASSWORD')
        db_dsn = os.getenv('DB_DSN')

        # Oracle connection
        conn = oracledb.connect(
            user=db_user,
            password=db_password,
            dsn=db_dsn
        )
        print('Connected to the DB!')
        return conn  
    except Exception as e:
        print("Error connecting to DB")
        print(e)
        return None  

if __name__ == '__main__':
    conn = connectCMMS()
    if conn:  
        try:
            output_file = "output_data.csv"  
            csv_file = query_to_csv(conn, output_file)
            if csv_file:
                
                hostname = os.getenv('SFTP_HOST')
                port = int(os.getenv('SFTP_PORT'))  
                username = os.getenv('SFTP_USER')
                password = os.getenv('SFTP_PASSWORD')
                remote_path = os.getenv('SFTP_PATH')

                # CSV al servidor
                upload_to_server(csv_file, remote_path, hostname, port, username, password)
        finally:
            conn.close()  
    else:
        print("Unable to establish a database connection.")