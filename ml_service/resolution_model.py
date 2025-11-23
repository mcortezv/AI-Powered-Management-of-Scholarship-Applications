from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import confusion_matrix, classification_report
from sklearn.model_selection import GridSearchCV
import joblib

def resolution_model(X_train_resolution_smote, X_val_s, X_test_s, Y_train_resolution_smote, Y_val_s, Y_test_s):

    parameters = {
        'n_estimators': [25, 50, 100],
        'max_depth': [None, 6, 3, 3],
        'min_samples_split': [2, 2, 1]
    }

    parameters_search = GridSearchCV(RandomForestClassifier(random_state=42), parameters, cv=4, scoring = 'f1_macro')
    parameters_search.fit(X_train_resolution_smote, Y_train_resolution_smote)

    model = parameters_search.best_estimator_

    Y_val_pred = model.predict(X_val_s)
    Y_test_pred = model.predict(X_test_s)

    print("\nConfusion Matrix Resolution Model Validation: ")
    print(confusion_matrix(Y_val_s, Y_val_pred))
    print("\nClasification Report Resolution Model Validation: ")
    print(classification_report(Y_val_s, Y_val_pred))

    print("\nConfusion Matrix Resolution Model Test: ")
    print(confusion_matrix(Y_test_s, Y_test_pred))
    print("\nClasification Report Resolution Model Test:")
    print(classification_report(Y_test_s, Y_test_pred))

    joblib.dump(model, 'saved/resolution_model.pkl')
