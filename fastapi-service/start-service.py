from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()

# Sample GET call
@app.get("/")
async def root():
    return {"message" : "Hi from FastAPI!"}

# Handling params
@app.get("/items/{item_id}")
async def read_item(item_id):
    return {"item_id": item_id}

# integer params
@app.get("/int_items/{int_item}")
async def read_item_int(int_item: int):
    return {"int_item": int_item}

# return list
@app.get("/users")
async def read_users():
    return ["Rick", "Morty","Steve","Joe"]

class Item(BaseModel):
    name: str
    description: str | None = None
    price: float
    tax: float | None = None

@app.post("/items/")
async def create_item(item: Item):
    return item