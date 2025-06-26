import asyncio


# ------------------ Step 1: Multiply Values ------------------
async def multiply_by_constant(data: dict, constant: int):
    print("[Stage 1] Multiplying values...")
    for key in data:
        data[key] *= constant
    print(f"\tDone: {data}")
    await asyncio.sleep(0.1)  # simulate delay


# ------------------ Step 2: Add in Pairs ------------------
async def add_in_pairs(data: dict):
    print("[Stage 2] Adding values two by two...")
    keys = sorted(data.keys())
    new_data = {}
    for i in range(0, len(keys), 2):
        if i + 1 < len(keys):
            a, b = keys[i], keys[i + 1]
            new_data[a] = data[a] + data[b]
        else:
            new_data[keys[i]] = data[keys[i]]
    data.clear()
    data.update(new_data)
    print(f"\tDone: {data}")
    await asyncio.sleep(0.1)


# ------------------ Step 3: Replace Even Values ------------------
async def zero_even_values(data: dict):
    print("[Stage 3] Zeroing even values...")
    for key in data:
        if data[key] % 2 == 0:
            data[key] = 0
    print(f"\tDone: {data}")
    await asyncio.sleep(0.1)


# ------------------ Orchestrator ------------------
async def process_pipeline(data: dict):
    await multiply_by_constant(data, constant=2)
    await add_in_pairs(data)
    await zero_even_values(data)


# ------------------ Main ------------------
def main():
    data = {0: 2, 1: 7, 2: 8, 3: 3}
    print("Initial Data:", data)

    asyncio.run(process_pipeline(data))


if __name__ == "__main__":
    main()
