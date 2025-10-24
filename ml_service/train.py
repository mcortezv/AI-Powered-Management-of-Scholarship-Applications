import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler, LabelEncoder, LabelBinarizer
from imblearn.over_sampling import SMOTE
from resolution_model import resolution_model
from reason_model import reason_model


def train():
    le = LabelEncoder()
    scaler = StandardScaler()

    data = pd.read_csv('data/data.csv')

    X = data[['Student GPA', 'Dropout Rate', 'Failure Rate', 'Semester',
              'Degree Program', 'Course Load', 'Total Household Income', 'Housing Type',
              'Employment', 'Debts', 'Category', 'Number of Scholarships Awarded']]


    X.loc[:, 'Degree Program'] = le.fit_transform(X['Degree Program'])
    X.loc[:, 'Housing Type'] = le.fit_transform(X['Housing Type'])
    X.loc[:, 'Category'] = le.fit_transform(X['Category'])

    Y_resolution = data['Resolution']
    Y_reason = data['Reason']

    #Queda pediente el balanceo y estratificacion de datos por falta de datos


    X_tran, X_temp, Y_train_resolution, Y_temp_resolution, Y_train_reason, Y_temp_reason = (
        train_test_split(X, Y_resolution, Y_reason, test_size=0.4, random_state=42))

    X_val, X_test, Y_val_resolution, Y_test_resolution, Y_val_reason, Y_test_reason = (
        train_test_split(X_temp, Y_temp_resolution, Y_temp_reason, test_size=0.5,
                         random_state=42, stratify=Y_temp_resolution))




    resolution_model(X_tran, X_val, X_test, Y_train_resolution, Y_val_resolution, Y_test_resolution)
    reason_model(X_tran, X_val, X_test, Y_train_reason, Y_val_reason, Y_test_reason)