import joblib
import numpy as np
from fastapi import FastAPI
from pydantic import BaseModel

class InputData(BaseModel):
    features: list

def main():
    app = FastAPI()
    resolution_model = joblib.load('saved/resolution_model.pkl')
    reason_model = joblib.load('saved/reason_model.pkl')

    @app.post('/predict')
    def predict(data: InputData):
        X = np.array([data.features])

        resolution = resolution_model.predict(X)[0]
        reason = reason_model.predict(X)[0]

        resolution_confidence = np.max(resolution_model.predict_proba(X)[0]) * 100
        reason_confidence = np.max(reason_model.predict_proba(X)[0]) * 100
        confidence = (resolution_confidence + reason_confidence) / 2

        return {
            'resolution': resolution,
            'reason': reason,
            'confidence': confidence
        }


if __name__ == '__main__':
    main()
