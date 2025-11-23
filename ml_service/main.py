import joblib
from train import train


def main():

    option = input('Entrenar o Cargar (0, 1): ')
    if option == '0':
        train()
        return

    resolution_model = joblib.load('saved/resolution_model.pkl')
    reason_model = joblib.load('saved/reason_model.pkl')


if __name__ == '__main__':
    main()
