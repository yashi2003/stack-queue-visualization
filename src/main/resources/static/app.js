const BASE_URL = '/api';

// map 'array' / 'linked' -> backend impl names
function mapImpl(impl) {
    // backend expects "array" or "linkedlist"
    return impl === 'array' ? 'array' : 'linkedlist';
}

function renderStructureState(state, infoElementId, elementsContainerId) {
    const infoEl = document.getElementById(infoElementId);
    const elemEl = document.getElementById(elementsContainerId);

    infoEl.textContent =
        `Type: ${state.type}
Impl: ${state.impl}
Size: ${state.size}
Capacity: ${state.capacity ?? '-'}
TopIndex: ${state.topIndex ?? '-'}
FrontIndex: ${state.frontIndex ?? '-'}
RearIndex: ${state.rearIndex ?? '-'}
LastOperation: ${state.lastOperation ?? '-'}
Message: ${state.message ?? '-'}`;

    elemEl.innerHTML = '';
    if (state.elements) {
        state.elements.forEach((val) => {
            const div = document.createElement('div');
            div.className = 'box';
            div.textContent = val;
            elemEl.appendChild(div);
        });
    }
}

// ---------- STACK ----------

async function pushStack(impl) {
    const inputId = impl === 'array' ? 'stackArrayValue' : 'stackLinkedValue';
    const infoId = impl === 'array' ? 'stackArrayInfo' : 'stackLinkedInfo';
    const elemId = impl === 'array' ? 'stackArrayElements' : 'stackLinkedElements';

    const val = document.getElementById(inputId).value;
    if (val === '') return;

    const mappedImpl = mapImpl(impl);

    const res = await fetch(`${BASE_URL}/stack/${mappedImpl}/push?value=${encodeURIComponent(val)}`, {
        method: 'POST'
    });
    const data = await res.json();
    renderStructureState(data, infoId, elemId);
}

async function popStack(impl) {
    const infoId = impl === 'array' ? 'stackArrayInfo' : 'stackLinkedInfo';
    const elemId = impl === 'array' ? 'stackArrayElements' : 'stackLinkedElements';

    const mappedImpl = mapImpl(impl);

    const res = await fetch(`${BASE_URL}/stack/${mappedImpl}/pop`, {
        method: 'POST'
    });
    const data = await res.json();
    renderStructureState(data, infoId, elemId);
}

async function loadStackState(impl) {
    const infoId = impl === 'array' ? 'stackArrayInfo' : 'stackLinkedInfo';
    const elemId = impl === 'array' ? 'stackArrayElements' : 'stackLinkedElements';

    const mappedImpl = mapImpl(impl);

    const res = await fetch(`${BASE_URL}/stack/${mappedImpl}/state`);
    const data = await res.json();
    renderStructureState(data, infoId, elemId);
}

// ---------- QUEUE ----------

async function enqueueQueue(impl) {
    const inputId = impl === 'array' ? 'queueArrayValue' : 'queueLinkedValue';
    const infoId = impl === 'array' ? 'queueArrayInfo' : 'queueLinkedInfo';
    const elemId = impl === 'array' ? 'queueArrayElements' : 'queueLinkedElements';

    const val = document.getElementById(inputId).value;
    if (val === '') return;

    const mappedImpl = mapImpl(impl);

    const res = await fetch(`${BASE_URL}/queue/${mappedImpl}/enqueue?value=${encodeURIComponent(val)}`, {
        method: 'POST'
    });
    const data = await res.json();
    renderStructureState(data, infoId, elemId);
}

async function dequeueQueue(impl) {
    const infoId = impl === 'array' ? 'queueArrayInfo' : 'queueLinkedInfo';
    const elemId = impl === 'array' ? 'queueArrayElements' : 'queueLinkedElements';

    const mappedImpl = mapImpl(impl);

    const res = await fetch(`${BASE_URL}/queue/${mappedImpl}/dequeue`, {
        method: 'POST'
    });
    const data = await res.json();
    renderStructureState(data, infoId, elemId);
}

async function loadQueueState(impl) {
    const infoId = impl === 'array' ? 'queueArrayInfo' : 'queueLinkedInfo';
    const elemId = impl === 'array' ? 'queueArrayElements' : 'queueLinkedElements';

    const mappedImpl = mapImpl(impl);

    const res = await fetch(`${BASE_URL}/queue/${mappedImpl}/state`);
    const data = await res.json();
    renderStructureState(data, infoId, elemId);
}

// initial load when page opens
window.addEventListener('DOMContentLoaded', () => {
    loadStackState('array');
    loadStackState('linked');
    loadQueueState('array');
    loadQueueState('linked');
});
