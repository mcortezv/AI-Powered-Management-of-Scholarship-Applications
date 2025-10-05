import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler, LabelEncoder, LabelBinarizer
from imblearn.over_sampling import SMOTE
from resolution_model import resolution_model
from reason_model import reason_model


def train():
    lb = LabelBinarizer()
    le = LabelEncoder()
    scaler = StandardScaler()

    data = pd.concat([
        pd.read_csv('data/academic_history.csv', ),
        pd.read_csv('data/socioeconomic_information.csv'),
        pd.read_csv('data/scholarship_data.csv'),
        pd.read_csv('data/resolutions.csv'),])

    X = data[['Student GPA', 'Dropout Rate', 'Failure Rate', 'Semester',
              'Degree Program', 'Course Load', 'Total Household Income',
              'Employment', 'Debts', 'Category', 'Number of Scholarships Awarded']]


    X.loc[:, 'Employment'] = lb.fit_transform(X['Employment'])
    X.loc[:, 'Debts'] = lb.fit_transform(X['Debts'])
    X.loc[:, 'Category'] = lb.fit_transform(X['Category'])
    X.loc[:, 'Degree Program'] = le.fit_transform(X['Degree Program'])


    Y_resolution = data['Resolution']
    Y_reason = data['Reason']


    X_tran, X_temp, Y_train_resolution, Y_temp_resolution, Y_train_reason, Y_temp_reason = (
        train_test_split(X, Y_resolution, Y_reason, test_size=0.4, random_state=42))

    X_val, X_test, Y_val_resolution, Y_test_resolution, Y_val_reason, Y_test_reason = (
        train_test_split(X_temp, Y_temp_resolution, Y_temp_reason, test_size=0.5,
                         random_state=42, stratify=Y_temp_resolution))


    X_tran_s = scaler.fit_transform(X_tran)
    X_val_s = scaler.transform(X_val)
    X_test_s = scaler.transform(X_test)

    smote = SMOTE(random_state=42)
    X_train_resolution_smote, Y_train_resolution_smote = smote.fit_resample(X_tran_s, Y_train_resolution)
    X_train_reason_smote, Y_train_reason_smote = smote.fit_resample(X_tran_s, Y_train_reason)

    resolution_model(X_train_resolution_smote, X_val_s, X_test_s, Y_train_resolution_smote, Y_val_resolution, Y_test_resolution)
    reason_model(X_train_reason_smote, X_val_s, X_test_s, Y_train_reason_smote, Y_val_reason, Y_test_reason)
